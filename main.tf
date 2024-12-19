provider "aws" {
  region = "us-east-1"
}


resource "aws_lambda_function" "init_tables" {
  function_name = "InitDynamoDBTables"
  role          = aws_iam_role.lambda_exec.arn
  handler       = "index.handler"
  runtime       = "nodejs16.x"
  filename      = "lambda.zip"

  environment {
    variables = {
      DYNAMODB_TABLE_CLUBS = aws_dynamodb_table.clubs_table.name
      DYNAMODB_TABLE_POSTS = aws_dynamodb_table.post_table.name
      DYNAMODB_TABLE_USERS = aws_dynamodb_table.user_table.name
    }
  }
}

resource "aws_iam_role" "lambda_exec" {
  name = "LambdaExecutionRole"

  assume_role_policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Action = "sts:AssumeRole"
        Effect = "Allow"
        Principal = {
          Service = "lambda.amazonaws.com"
        }
      }
    ]
  })
}

resource "aws_iam_role_policy_attachment" "lambda_policy" {
  role       = aws_iam_role.lambda_exec.name
  policy_arn = "arn:aws:iam::aws:policy/AmazonDynamoDBFullAccess"
}
resource "aws_dynamodb_table" "clubs_table" {
  name           = "ClubsTable"
  billing_mode   = "PAY_PER_REQUEST"
  hash_key       = "id"

  attribute {
    name = "id"
    type = "N"
  }

  attribute {
    name = "logo"
    type = "S"
  }

  attribute {
    name = "ownerEmail"
    type = "S"
  }

  attribute {
    name = "name"
    type = "S"
  }

  attribute {
    name = "license"
    type = "S"
  }

  attribute {
    name = "latitude"
    type = "N"
  }

  attribute {
    name = "longitude"
    type = "N"
  }

  attribute {
    name = "cover"
    type = "N"
  }

  attribute {
    name = "schedule"
    type = "S"
  }

  attribute {
    name = "recommendations"
    type = "S"
  }

  attribute {
    name = "contactNumber"
    type = "N"
  }

  attribute {
    name = "tags"
    type = "S"
  }

  attribute {
    name = "likes"
    type = "N"
  }

  attribute {
    name = "zone"
    type = "S"
  }

  attribute {
    name = "logoString"
    type = "S"
  }

  dynamic "global_secondary_index" {
    for_each = [
      "logo", "ownerEmail", "name", "license", "latitude", "longitude", "cover",
      "schedule", "recommendations", "contactNumber", "tags", "likes", "zone", "logoString"
    ]

    content {
      name               = "${global_secondary_index.value}Index"
      hash_key           = global_secondary_index.value
      projection_type    = "ALL"
    }
  }
}
resource "aws_dynamodb_table" "post_table" {
  name           = "PostTable"
  billing_mode   = "PAY_PER_REQUEST"
  hash_key       = "id"

  attribute {
    name = "id"
    type = "N"
  }
  attribute {
    name = "title"
    type = "S"
  }
  attribute {
    name = "date"
    type = "S"
  }
  attribute {
    name = "description"
    type = "S"
  }
  attribute {
    name = "image"
    type = "S"
  }
  attribute {
    name = "clubId"
    type = "N"
  }
  attribute {
    name = "imageString"
    type = "S"
  }
  dynamic "global_secondary_index" {
    for_each = [
      "title", "date", "description", "image", "clubId", "imageString"
    ]

    content {
      name               = "${global_secondary_index.value}Index"
      hash_key           = global_secondary_index.value
      projection_type    = "ALL"
    }
  }
}

resource "aws_dynamodb_table" "user_table" {
  name           = "EventsTable"
  billing_mode   = "PAY_PER_REQUEST"
  hash_key       = "id"

  attribute {
    name = "id"
    type = "N"
  }
  attribute {
    name = "username"
    type = "S"
  }
  attribute {
    name = "email"
    type = "S"
  }
  attribute {
    name = "cellphone"
    type = "N"
  }
  attribute {
    name = "birthday"
    type = "S"
  }
  attribute {
    name = "ci"
    type = "N"
  }
  attribute {
    name = "likedIdClubs"
    type = "N"
  }
  attribute {
    name = "profilePictureString"
    type = "S"
  }
  dynamic "global_secondary_index" {
    for_each = [
      "username", "email", "cellphone", "birthday", "ci", "likedIdClubs", "profilePictureString"
    ]

    content {
      name               = "${global_secondary_index.value}Index"
      hash_key           = global_secondary_index.value
      projection_type    = "ALL"
    }
  }
}

output "tables" {
  value = {
    clubs   = aws_dynamodb_table.clubs_table.name
    post = aws_dynamodb_table.post_table.name
    users  = aws_dynamodb_table.user_table.name
  }
}

resource "aws_apigatewayv2_api" "lambda_api" {
  name          = "InitTablesAPI"
  protocol_type = "HTTP"
}

resource "aws_apigatewayv2_integration" "lambda_integration" {
  api_id             = aws_apigatewayv2_api.lambda_api.id
  integration_type   = "AWS_PROXY"
  integration_uri    = aws_lambda_function.init_tables.invoke_arn
  payload_format_version = "2.0"
}

resource "aws_apigatewayv2_route" "lambda_route" {
  api_id    = aws_apigatewayv2_api.lambda_api.id
  route_key = "POST /init"
  target    = "integrations/${aws_apigatewayv2_integration.lambda_integration.id}"
}

resource "aws_lambda_permission" "api_gateway_permission" {
  statement_id  = "AllowAPIGatewayInvoke"
  action        = "lambda:InvokeFunction"
  function_name = aws_lambda_function.init_tables.function_name
  principal     = "apigateway.amazonaws.com"
  source_arn   = "${aws_apigatewayv2_api.lambda_api.execution_arn}/*/*"
}

output "api_endpoint" {
  value = aws_apigatewayv2_api.lambda_api.api_endpoint
}

package com.progra.loszetaz

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.ContextCompat
import android.view.View
import androidx.core.app.ActivityCompat
import com.progra.loszetaz.dataBase.PostDB
import com.progra.loszetaz.dataClases.Post
import com.progra.loszetaz.databinding.ActivityCreatePostBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class CreatePostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreatePostBinding

    var pickedPhoto: Uri? = null
    var pickedBitMap: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.confirmPostButton.setOnClickListener {
            val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale("es","ES"))
            val current = LocalDate.now().format(formatter)
            if(binding.postTitle.text.toString().isNotEmpty() && pickedBitMap != null) {
                val post = Post(
                    title = binding.postTitle.text.toString(),
                    description = binding.descriptionPost.text.toString(),
                    clubId = 5,
                    image = pickedBitMap!!,
                    date = current,
                )
                PostDB.addPost(post)
                finish()
            }
            else{
                //TODO Mostrar que no puedes crear sin titulo y sin imagen
            }
        }
        binding.cancelPostButton.setOnClickListener {
           finish()
        }
    }

    fun pickedPhoto(view: View) {
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                1)
        else{
            val galleryIntext = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntext, 2)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            val galleryIntext =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntext, 2)
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 2 && resultCode == Activity.RESULT_OK && data != null){
            pickedPhoto = data.data
            val source = ImageDecoder.createSource(this.contentResolver, pickedPhoto!!)
            pickedBitMap = ImageDecoder.decodeBitmap(source)
            pickedBitMap = Bitmap.createScaledBitmap(pickedBitMap!!,500,500,false)
            //binding.uploadedImage.setImageBitmap(pickedBitMap)
            val d = BitmapDrawable(getResources(), pickedBitMap);
            binding.uploadedImage.setImageDrawable(d)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
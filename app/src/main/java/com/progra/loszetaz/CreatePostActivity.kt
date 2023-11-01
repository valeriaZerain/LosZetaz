package com.progra.loszetaz

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.ContextCompat
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.progra.loszetaz.dataBase.PostDB
import com.progra.loszetaz.databinding.ActivityCreatePostBinding
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class CreatePostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreatePostBinding

    var pickedPhoto: Uri? = null
    var pickedBitMap: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameClub = intent.getStringExtra(NAME_CLUB_KEY)
        binding.textClubName.text = nameClub

        binding.confirmPostButton.setOnClickListener {
            val now: Instant = Clock.System.now()
            val today: LocalDate = now.toLocalDateTime(TimeZone.currentSystemDefault()).date

            if (binding.postTitle.text.toString().isNotEmpty() && pickedBitMap != null) {

                val title = binding.postTitle.text.toString()
                val description = binding.descriptionPost.text.toString()
                val clubId = GlobalConfig.actualClub!!.id
                val imageString = pickedPhoto!!.toString()
                val date = today

                PostDB.addPost(title, description, clubId, imageString, date, this)
                finish()
            } else {
                val toast = Toast.makeText(
                    this,
                    "El titulo y la imagen no pueden estar vacios", Toast.LENGTH_SHORT
                )
                toast.show()
            }
        }
        binding.cancelPostButton.setOnClickListener {
            finish()
        }
        binding.iconUser.setOnClickListener {
            val intent: Intent = Intent(this, MyInformationActivity::class.java)
            startActivity(intent)
        }
    }

    fun pickedPhoto(view: View) {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        )
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )
        else {
            val galleryIntext =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
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
        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null) {
            pickedPhoto = data.data
            val source = ImageDecoder.createSource(this.contentResolver, pickedPhoto!!)
            pickedBitMap = ImageDecoder.decodeBitmap(source)
            pickedBitMap = Bitmap.createScaledBitmap(pickedBitMap!!, 500, 500, false)
            binding.uploadedImage.setImageBitmap(pickedBitMap)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
        val NAME_CLUB_KEY = "name_club_key"
    }
}
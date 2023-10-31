package com.progra.loszetaz

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.dataBase.TagsEnum
import com.progra.loszetaz.dataBase.UserDB
import com.progra.loszetaz.databinding.ActivityRegisterClientBinding
import com.progra.loszetaz.databinding.ActivityRegisterClubBinding

class RegisterClubActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegisterClubBinding

    val context: Context = this
    var pickedPhoto: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterClubBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.logoPlaceholder.setOnClickListener {
            view -> pickedPhoto(view)
        }

        binding.buttonCreateaccount.setOnClickListener {
            val email: String = binding.edittextOwneremail.text.toString()
            val password: String = binding.edittextPassword.text.toString()
            clickCreateAccount(email, password)
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
            binding.logoPlaceholder.setImageURI(pickedPhoto)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


    fun clickCreateAccount(email: String, password: String) {

        val clubName: String = binding.edittextClubname.text.toString()
        val license: String = binding.edittextLicense.text.toString()
        val schedule: String = binding.edittextSchedule.text.toString()
        if(pickedPhoto != null
            && clubName.isNotEmpty()
            && email.isNotEmpty()
            && password.isNotEmpty()
            && license.isNotEmpty()
            && schedule.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser

                        val phoneNumber: Int =
                            binding.edittextPhonenumerclub.text.toString().toInt()
                        val description: String = binding.edittextDescription.text.toString()
                        val location: String = binding.edittextLocation.text.toString()
                        val contact: Int = binding.edittextContact.text.toString().toInt()
                        val cover: Int = binding.edittextCover.text.toString().toInt()
                        var recommendations: String =
                            binding.edittextRecommendations.text.toString()
                        val tags: MutableList<Boolean> =
                            mutableListOf(false, false, false, false, false)
                        tags.set(TagsEnum.TABLE.id, binding.checkboxTables.isChecked)
                        tags.set(TagsEnum.OUTSIDE.id, binding.checkboxOutside.isChecked)
                        tags.set(TagsEnum.OLDIES.id, binding.checkboxOldies.isChecked)
                        tags.set(TagsEnum.NOCOVER.id, binding.checkboxNoCover.isChecked)
                        tags.set(TagsEnum.LIVE.id, binding.checkboxLiveMusic.isChecked)
                        ClubDB.addClub(
                            name = clubName,
                            ownerEmail = email,
                            license = license,
                            ownerNumber = phoneNumber,
                            description = description,
                            cover = cover,
                            schedule = schedule,
                            recommendations = recommendations,
                            contactNumber = contact,
                            tags = tags,
                            location = location,
                            userFirebaseId = user!!.uid,
                            context = context,
                            logoString = pickedPhoto.toString()
                        )

                        GlobalConfig.markAsClub(user)
                        GlobalConfig.initUser(user)

                        val intent = Intent(context, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        val toast = Toast.makeText(
                            this,
                            "No se pudo registrar el usuario correctamente", Toast.LENGTH_SHORT
                        )
                        toast.show()
                    }
                }
        }
        else{
            val toast = Toast.makeText(
                this,
                "Todos los datos con * son obligatorios", Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }
}
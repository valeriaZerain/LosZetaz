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
import android.provider.MediaStore.Images
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.progra.loszetaz.dataBase.UserDB
import com.progra.loszetaz.databinding.ActivityRegisterClientBinding

class RegisterClientActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegisterClientBinding
    val context: Context = this
    var pickedPhoto: Uri? = null
    var pickedBitMap: Bitmap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.profilePlaceholder.setOnClickListener {
            view -> pickedPhoto(view)
        }
        binding.buttonCreateaccount.setOnClickListener {
            val email: String = binding.edittextEmail.text.toString()
            val password: String = binding.edittextPassword.text.toString()
            clickCreateAccount(email, password)
        }
    }

    fun pickedPhoto(view: View) {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )
        } else {
            val galeriIntex =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galeriIntex, 2)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val galeriIntext =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeriIntext, 2)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null) {
            pickedPhoto = data.data
            if (pickedPhoto != null) {
                val source = ImageDecoder.createSource(this.contentResolver, pickedPhoto!!)
                pickedBitMap = ImageDecoder.decodeBitmap(source)
                pickedBitMap = Bitmap.createScaledBitmap(pickedBitMap!!,500,500,false)
                binding.profilePlaceholder.setImageBitmap(pickedBitMap)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun clickCreateAccount(email: String, password: String) {

        val username: String = binding.edittextUsernameclient.text.toString()
        val phone: Int = binding.edittextPhonenumberclient.text.toString().toInt()
        val birthday: String = binding.edittextBirthday.text.toString()
        val ci: Int = binding.edittextCi.text.toString().toInt()

        if(
            username.isNotEmpty() &&
            phone != 0 &&
            birthday.isNotEmpty() &&
            ci != 0 &&
            pickedPhoto != null
        ) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        UserDB.addUser(
                            username,
                            email,
                            phone,
                            birthday,
                            ci,
                            pickedPhoto!!.toString(),
                            user!!.uid,
                            context
                        )

                        GlobalConfig.markAsClient(user)
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
                "Llena todos los datos", Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }
}
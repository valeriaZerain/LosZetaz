package com.progra.loszetaz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterClubBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.buttonCreateaccount.setOnClickListener {
            val email: String = binding.edittextOwneremail.text.toString()
            val password: String = binding.edittextPassword.text.toString()
            clickCreateAccount(email, password)
        }
    }

    fun clickCreateAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val clubName: String = binding.edittextClubname.toString()
                    val license: String = binding.edittextLicense.toString()
                    val phoneNumber: Int = binding.edittextPhonenumerclub.toString().toInt()
                    val description: String = binding.edittextDescription.toString()
                    val schedule: String = binding.edittextSchedule.toString()
                    val location: String = binding.edittextLocation.toString()
                    val contact: Int = binding.edittextContact.toString().toInt()
                    val cover: Int = binding.edittextCover.toString().toInt()
                    var recommendations: String = binding.edittextRecommendations.toString()
                    val tags: MutableList<Boolean> = mutableListOf()
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
                        location = location
                    )
                    val intent = Intent(context, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    val toast = Toast.makeText(this,
                        "No se pudo registrar el usuario correctamente", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
    }
}
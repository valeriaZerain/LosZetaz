package com.progra.loszetaz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
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
            val email:String= binding.edittextOwneremail.text.toString()
            val password:String= binding.edittextPassword.text.toString()
            clickCreateAccount(email, password)
        }
    }

    fun clickCreateAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val intent = Intent(context, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    print("Voy a llorar")
                }
            }
    }
}
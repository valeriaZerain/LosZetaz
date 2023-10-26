package com.progra.loszetaz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.progra.loszetaz.databinding.ActivityRegisterClientBinding

class RegisterClientActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegisterClientBinding
    val context: Context = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.buttonCreateaccount.setOnClickListener {
            var email:String= binding.edittextEmail.text.toString()
            var password:String= binding.edittextPassword.text.toString()
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
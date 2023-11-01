package com.progra.loszetaz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.progra.loszetaz.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.buttonSignin.setOnClickListener {
            var username: String = binding.edittextUsername.text.toString()
            var password: String = binding.edittextPassword.text.toString()
            loginUser(username, password)
        }

        binding.buttonRegister.setOnClickListener {
            val intent = Intent(context, QuestionRegisterActivity::class.java)
            startActivity(intent)
        }
    }

    fun loginUser(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        GlobalConfig.initUser(user)

                        if (GlobalConfig.isUserClient) {
                            val intent = Intent(context, HomeScreenActivity::class.java)
                            startActivity(intent)
                        } else {
                            val clubProfile = Intent(context, ClubProfileActivity::class.java)
                            startActivity(clubProfile)
                        }
                    } else {
                        val toast = Toast.makeText(
                            this,
                            "La contraseña o el usuario son incorrectos", Toast.LENGTH_SHORT
                        )
                        toast.show()
                    }
                }
        } else {
            val toast = Toast.makeText(
                this,
                "Usuario y/o contraseña son incorrectas", Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }
}
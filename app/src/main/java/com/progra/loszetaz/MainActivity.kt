package com.progra.loszetaz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import com.google.firebase.auth.FirebaseAuth
import com.progra.loszetaz.GlobalConfig.Companion.isUserClient
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.dataBase.PostDB
import com.progra.loszetaz.dataBase.UserDB
import com.progra.loszetaz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalConfig.initPreferences(context)
        UserDB.loadUsers()
        PostDB.loadPosts()
        ClubDB.loadClubs()

        val handler = android.os.Handler(Looper.getMainLooper())
        handler.postDelayed({
            val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                GlobalConfig.initUser(user)
                if (isUserClient) {
                    val home = Intent(this, HomeScreenActivity::class.java)
                    startActivity(home)
                } else {
                    val profile = Intent(this, ClubProfileActivity::class.java)
                    startActivity(profile)
                }
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 2000)
    }
}
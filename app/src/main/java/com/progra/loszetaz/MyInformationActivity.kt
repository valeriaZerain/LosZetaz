package com.progra.loszetaz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.progra.loszetaz.GlobalConfig.Companion.actualClient
import com.progra.loszetaz.GlobalConfig.Companion.actualClub
import com.progra.loszetaz.databinding.ActivityMyInformationBinding

class MyInformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (GlobalConfig.isUserAClient()) {

            binding.topMenu.setBackgroundColor(getColor(R.color.purple))
            binding.clientLayout.visibility = View.VISIBLE

            val client = actualClient!!
            binding.userCi.text = client.ci.toString()
            binding.userBirthday.text = client.birthday
            binding.userEmail.text = client.email
            binding.userName.text = client.name
            binding.userPhone.text = client.cellphone.toString()
            binding.userImage.setImageURI(Uri.parse(client.profilePictureString))
        } else {

            binding.clientLayout.visibility = View.GONE
            binding.topMenu.setBackgroundColor(getColor(R.color.fucsia))

            val club = actualClub!!
            binding.userEmail.text = club.ownerEmail
            binding.userPhone.text = club.contactNumber.toString()
        }
        binding.logOutButton.setOnClickListener {
            Firebase.auth.signOut()
            actualClient = null
            actualClub = null
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.iconHomescreen.setOnClickListener {
            val intent: Intent = Intent(this, HomeScreenActivity::class.java)
            startActivity(intent)
        }
    }
}
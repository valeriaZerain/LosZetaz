package com.progra.loszetaz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.progra.loszetaz.GlobalConfig.Companion.CLUB_KEY
import com.progra.loszetaz.GlobalConfig.Companion.USER_KEY
import com.progra.loszetaz.dataClases.Club
import com.progra.loszetaz.dataClases.User
import com.progra.loszetaz.databinding.ActivityMyInformationBinding

class MyInformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (GlobalConfig.isUserAClient()){

            binding.topMenu.setBackgroundColor(getColor(R.color.purple))
            binding.clientLayout.visibility = View.VISIBLE

            val client = intent.getSerializableExtra(USER_KEY) as User
            binding.userCi.text = client.ci.toString()
            binding.userBirthday.text = client.birthday
            binding.userEmail.text = client.email
            binding.userName.text = client.name
            binding.userPhone.text = client.cellphone.toString()
            binding.userImage.setImageURI(Uri.parse(client.profilePictureString))
        }
        else{

            binding.clientLayout.visibility = View.GONE
            binding.topMenu.setBackgroundColor(getColor(R.color.fucsia))

            val club = intent.getBooleanArrayExtra(CLUB_KEY) as Club
            binding.userEmail.text = club.ownerEmail
            binding.userPhone.text = club.contactNumber.toString()
        }
        binding.logOutButton.setOnClickListener {
            Firebase.auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
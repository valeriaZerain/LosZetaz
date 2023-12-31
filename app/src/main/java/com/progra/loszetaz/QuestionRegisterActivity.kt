package com.progra.loszetaz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.progra.loszetaz.databinding.ActivityQuestionRegisterBinding

class QuestionRegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionRegisterBinding
    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ButtonClient.setOnClickListener {
            val intent1: Intent = Intent(context, RegisterClientActivity::class.java)
            startActivity(intent1)
        }
        binding.ButtonClub.setOnClickListener {
            val intent2: Intent = Intent(context, RegisterClubActivity::class.java)
            startActivity(intent2)
        }
    }
}
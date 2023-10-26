package com.progra.loszetaz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.progra.loszetaz.adapters.MostLikedClubAdapter
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    private val mostLikedClubAdapter by lazy { MostLikedClubAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showMostLikedClubs()
    }

    fun showMostLikedClubs(){

        mostLikedClubAdapter.addClubs(ClubDB.mostLikedClubs())
        binding.mostLikedClubRecylcer.apply{
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = mostLikedClubAdapter
        }

    }
}
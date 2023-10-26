package com.progra.loszetaz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.progra.loszetaz.databinding.ActivityMapBinding
import com.progra.loszetaz.fragment.MapsFragment

class MapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapBinding
    val context:Context=this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragment = MapsFragment()
        supportFragmentManager.commit {
            replace(binding.mapFragment.id,fragment)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }

        binding.imageSearch.setOnClickListener{
            val intent=Intent(this, SearchScreenActivity::class.java)
            startActivity(intent)
        }
    }
}
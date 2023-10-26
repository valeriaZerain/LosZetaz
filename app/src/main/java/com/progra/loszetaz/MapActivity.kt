package com.progra.loszetaz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.progra.loszetaz.databinding.ActivityMapBinding
import com.progra.loszetaz.fragment.MapsFragment

class MapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapBinding
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
    }

}
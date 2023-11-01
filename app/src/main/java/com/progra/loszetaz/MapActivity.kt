package com.progra.loszetaz

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.commit
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.Marker
import com.progra.loszetaz.ClubProfileActivity.Companion.CLUB_KEY
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.databinding.ActivityMapBinding
import com.progra.loszetaz.fragment.MapsFragment

class MapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapBinding
    val context: Context = this
    companion object {
        const val REQUEST_CODE_LOCATION = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragment = MapsFragment()
        supportFragmentManager.commit {
            replace(binding.mapFragment.id, fragment)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }

        binding.imageSearch.setOnClickListener {
            val intent = Intent(this, SearchScreenActivity::class.java)
            startActivity(intent)
        }
        binding.imageHome.setOnClickListener {
            val intent = Intent(this, HomeScreenActivity::class.java)
            startActivity(intent)
        }

    }

}
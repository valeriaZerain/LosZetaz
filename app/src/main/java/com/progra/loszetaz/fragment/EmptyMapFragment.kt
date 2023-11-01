package com.progra.loszetaz.fragment

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.progra.loszetaz.GlobalConfig
import com.progra.loszetaz.R

class EmptyMapFragment : Fragment() {

    lateinit var mMap: GoogleMap

    private val callback = OnMapReadyCallback { googleMap ->

        mMap = googleMap

        val club = GlobalConfig.coordinateProfileClub
        if (club == null) {
            googleMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(-16.529046, -68.112800),
                    12f
                )
            )
        } else {
            googleMap.addMarker(MarkerOptions().position(club))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(club, 15f))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_empty_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}
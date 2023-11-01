package com.progra.loszetaz.fragment

import android.content.Intent
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
import com.progra.loszetaz.ClubProfileActivity
import com.progra.loszetaz.ClubProfileActivity.Companion.CLUB_KEY
import com.progra.loszetaz.R
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.dataClases.Club

class MapsFragment : Fragment() {

    lateinit var mMap: GoogleMap

    var zoomLevel = 12f
    var center = LatLng(-16.529046, -68.112800)

    private val callback = OnMapReadyCallback { googleMap ->
        mMap = googleMap

        val initialLocation = center
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLocation, zoomLevel))
        addMarkers(ClubDB.clubs)
        mMap.setOnMarkerClickListener { marker ->
            val intent = Intent(context, ClubProfileActivity::class.java)
            val clubId = marker.title!!.toInt()
            intent.putExtra(CLUB_KEY, ClubDB.getClubById(clubId))
            startActivity(intent)
            false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    fun addMarkers(listLocations: List<Club>) {
        listLocations.forEach {
            var id = it.id
            var latitude = it.latitude
            var longitude = it.longitude
            var latLng = LatLng(latitude, longitude)
            val markerOptions = MarkerOptions()
            markerOptions.title(id.toString())
            markerOptions.position(latLng)
            mMap.addMarker(markerOptions)
        }
    }

}

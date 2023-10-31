package com.progra.loszetaz.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.progra.loszetaz.R
import com.progra.loszetaz.dataBase.ClubDB
import com.progra.loszetaz.dataClases.Club

class MapsFragment : Fragment(){

    private lateinit var googleMap: GoogleMap
    private lateinit var mapView: MapView
    private val locationPermissionCode = 2
    val zoomLevel = 8f

    private val callback = OnMapReadyCallback { googleMap ->
        addMarkers(ClubDB.clubs)
        val initialLocation = LatLng(-16.529046, -68.112800)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLocation, zoomLevel))
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

    fun addMarkers(listLocations: List<Club>){
        val markerOptions = MarkerOptions()
        listLocations.forEach{
            var id = it.id
            var latitude = it.latitude
            var longitude = it.longitude
            var latLng = LatLng(latitude, longitude)
            markerOptions.position(latLng)
            googleMap.addMarker(markerOptions)
        }
    }

    override fun onMarkerClick(p0: Marker): Boolean {
        TODO("Not yet implemented")
    }

}

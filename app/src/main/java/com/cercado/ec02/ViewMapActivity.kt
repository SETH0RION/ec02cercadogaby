package com.cercado.ec02

import com.google.android.gms.maps.CameraUpdateFactory

import com.google.android.gms.maps.OnMapReadyCallback

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cercado.ec02.databinding.ActivityViewMapBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment

class ViewMapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityViewMapBinding
    private lateinit var googleMap : GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentMap = supportFragmentManager.findFragmentById(R.id.fcv_map) as SupportMapFragment
        fragmentMap.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        val idatCentroLocation = LatLng(-12.101224, -77.035919 )
        googleMap.addMarker(MarkerOptions().position(idatCentroLocation).title("Idat Centro"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(idatCentroLocation))

    }
}
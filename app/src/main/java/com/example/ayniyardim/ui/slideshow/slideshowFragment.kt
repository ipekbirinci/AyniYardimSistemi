package com.example.ayniyardim.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ayniyardim.databinding.FragmentSlideshowBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class SlideshowFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val view = binding.root

        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        return view
    }

//
override fun onMapReady(map: GoogleMap) {
    googleMap = map

    val turkeyLatLng = LatLng(39.925533, 32.866287) // Türkiye'nin koordinatları
    googleMap.addMarker(MarkerOptions().position(turkeyLatLng).title("Türkiye"))

    // Yakınlaştırma işlemi
    val zoomLevel = 10f // Yakınlaştırma düzeyi
    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(turkeyLatLng, zoomLevel))
}

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mapView.onDestroy()
        _binding = null
    }
}

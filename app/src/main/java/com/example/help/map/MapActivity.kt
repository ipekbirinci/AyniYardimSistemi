package com.example.help.map

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.help.ListingHelp.ListingActivity
import com.example.help.R
import com.example.help.dataBinding
import com.example.help.databinding.ActivityMapBinding
import com.example.help.login.LoginActivity
import com.example.help.register.RegisterActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(),OnMapReadyCallback {
    private val binding: ActivityMapBinding by dataBinding(R.layout.activity_map)
    private val mapActivityViewModel:MapActivityViewModel by viewModels ()
    var locationManager: LocationManager?=null
    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap
    //bu location kullanmak için


  //  private val LOCATION_PERMISSION_REQUEST_CODE = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        //nasıl konum alınır,LOCATİON MANAGER YARDIM TALEBİ OLUŞTURURKEN ALINAACAK PERMİSSİON ŞİMDİ
        locationManager=getSystemService(LOCATION_SERVICE) as LocationManager
        if(ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            //Konum isteği başlat
            KonumIstegi()
        }
        else{
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),1)
        }
        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        listener()

    }

    private fun listener() {
       // binding.spinnerCategory
        binding.Loginsayfasi.setOnClickListener {
            //Login activitye git
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.listelesayfasi.setOnClickListener {
            //listelesayfasına git
            val intent = Intent(this, ListingActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        KonumIstegi()
    }
    @SuppressLint("MissingPermission")
    private fun KonumIstegi(){
        locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,0.1f,locationlistener)

    }
    var locationlistener= object: LocationListener {
        override fun onLocationChanged(location: Location) {
            Toast.makeText(this@MapActivity," Lat: ${location.latitude}-Long : ${location.longitude}",
                Toast.LENGTH_SHORT).show()
        }
        override fun onProviderDisabled(provider:String){
            super.onProviderDisabled(provider)
            //pasif
        }

        override fun onProviderEnabled(provider: String) {
            super.onProviderEnabled(provider)
            //aktif
        }
    }
    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        val turkeyLatLng = LatLng(39.925533, 32.866287) // Türkiye'nin koordinatları
        googleMap.addMarker(MarkerOptions().position(turkeyLatLng).title("Türkiye"))
        // Yakınlaştırma işlemi
        val zoomLevel = 20f // Yakınlaştırma düzeyi
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(turkeyLatLng, zoomLevel))
    }


}

private fun MapView.getMapAsync(mapActivity: MapActivity) {
    this.getMapAsync(mapActivity)
}

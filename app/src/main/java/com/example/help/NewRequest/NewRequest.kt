package com.example.help.NewRequest


import android.content.Context
import android.content.Intent
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.activity.viewModels
import com.example.help.OfferHelp.OfferHelp


import com.example.help.R
import com.example.help.dataBinding
import com.example.help.databinding.ActivityNewRequestBinding
import com.example.help.network.data.Location

class NewRequest : AppCompatActivity() {
    private val binding: ActivityNewRequestBinding by dataBinding(R.layout.activity_new_request)
    private val newRequestViewModel: NewRequestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_request)

        observeViewModel()
        listener()
    }

    private fun observeViewModel(){
        newRequestViewModel.RequestsSuccessData.observe(this){
            val intent = Intent(this, OfferHelp::class.java)
            startActivity(intent)
        }
    }
    private fun listener() {
        // Kıyafet seçimi yapıldığında kiyafetSecimiLiveData'ya değer atanır

        binding.createRequest.setOnClickListener {
            val yardimTuru = binding.helpTypeSpinner.selectedItem.toString()
            val oncelik = binding.aciliyetSpinner.selectedItem.toString()
            val miktar = binding.miktarSpinner.selectedItem.toString()
            val aciklama = binding.detailTextField.text.toString()
            val sp = getSharedPreferences("userId", Context.MODE_PRIVATE)
            val userId =sp.getString("userId", "test")
            Log.d("userid","${userId}")
            val location = Location(X = 120, Y = 120)

    if (userId != null && oncelik != null && miktar != null && aciklama != null && location != null) {
        newRequestViewModel.createRequest(yardimTuru,oncelik,miktar,aciklama, userId,location)
    }


        }

    }
}

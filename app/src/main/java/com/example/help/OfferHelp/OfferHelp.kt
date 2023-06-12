package com.example.help.OfferHelp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.help.NewRequest.NewRequest
import com.example.help.R
import com.example.help.dataBinding
import com.example.help.databinding.ActivityLoginBinding
import com.example.help.databinding.ActivityOfferHelpBinding
import com.example.help.login.LoginViewModel

class OfferHelp : AppCompatActivity() {

    private val binding: ActivityOfferHelpBinding by dataBinding(R.layout.activity_offer_help)
    private val loginViewModel: LoginViewModel by viewModels ()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_help)

        listeners()
    }

    private fun listeners() {
        binding.button3.setOnClickListener {
            //bu yeni yardım talep et
            val intent = Intent(this, NewRequest::class.java)
            startActivity(intent)
        }
    }


}
package com.example.help.NewRequest

import android.annotation.SuppressLint
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
import com.example.help.R
import com.example.help.dataBinding
import com.example.help.databinding.ActivityNewRequestBinding

class NewRequest : AppCompatActivity() {
    private val binding : ActivityNewRequestBinding by dataBinding(R.layout.activity_new_request)
    private val newRequestViewModel : NewRequestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_request)

        listener()
    }

    private fun listener() {

    }

}
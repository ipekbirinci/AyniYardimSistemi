package com.example.help.ListingHelp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.help.R
import com.example.help.dataBinding
import com.example.help.databinding.ActivityListingBinding

class ListingActivity : AppCompatActivity() {
    private val binding: ActivityListingBinding by dataBinding(R.layout.activity_listing)
    private val listingActivityViewModel: ListingActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing)
    }
}
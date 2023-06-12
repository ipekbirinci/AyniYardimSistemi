package com.example.help.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.help.R
import com.example.help.dataBinding
import com.example.help.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding : ActivityDetailBinding by dataBinding(R.layout.activity_detail)
    private val detailActivityViewModel : DetailActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}
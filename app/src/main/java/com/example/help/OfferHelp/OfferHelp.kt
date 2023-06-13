package com.example.help.OfferHelp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.help.Adapters.YardimTalebiAdapter
import com.example.help.NewRequest.NewRequest
import com.example.help.R
import com.example.help.dataBinding
import com.example.help.databinding.ActivityOfferHelpBinding

class OfferHelp : AppCompatActivity() {

    private val binding: ActivityOfferHelpBinding by dataBinding(R.layout.activity_offer_help)
    private val offerHelpViewModel: OfferHelpViewModel by viewModels ()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_help)
        val sp = getSharedPreferences("userId", Context.MODE_PRIVATE)
        val userId =sp.getString("userId", "test")
        Log.d("userid","${userId}")

        if(userId!=null){
            offerHelpViewModel.getRequestByUser(userId)
        }


        offerHelpViewModel.isOfferSuccess.observe(this){
            val adapter=YardimTalebiAdapter(it.data)
            binding.yardimtalebiolusturview.adapter=adapter
        }

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
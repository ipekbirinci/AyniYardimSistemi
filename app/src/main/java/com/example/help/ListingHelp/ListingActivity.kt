package com.example.help.ListingHelp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.help.Adapters.YardimTalebiAdapter
import com.example.help.Adapters.listingAdapter
import com.example.help.Detail.DetailActivity
import com.example.help.R
import com.example.help.RowClickListener
import com.example.help.dataBinding
import com.example.help.databinding.ActivityListingBinding
import com.example.help.network.response.Help

class ListingActivity : AppCompatActivity() {
    private val binding: ActivityListingBinding by dataBinding(R.layout.activity_listing)
    private val listingActivityViewModel: ListingActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing)

        observeViewModels()
        listingActivityViewModel.getAllRequests()

    }
    private fun observeViewModels() {

        listingActivityViewModel.helpListData.observe(this) { helpList ->

            val adapter = listingAdapter(helpList, detailClickListener = object : RowClickListener<Help> {
                override fun onRowClick(pos: Int, item: Help) {
                    Log.d("ClickedEdit", item.requestDate)
//                    val intent = Intent(this, DetailActivity::class.java)
//                    startActivity(intent)
                }
            })
            binding.listviewrecclerview.adapter = adapter
            binding.listviewrecclerview.layoutManager = LinearLayoutManager(this@ListingActivity)

        }
    }
}
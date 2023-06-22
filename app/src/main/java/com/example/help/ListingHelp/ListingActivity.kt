package com.example.help.ListingHelp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.help.Adapters.listingAdapter
import com.example.help.Detail.DetailActivity
import com.example.help.R
import com.example.help.RowClickListener
import com.example.help.dataBinding
import com.example.help.databinding.ActivityListingBinding
import com.example.help.network.ListResponse.ListHelp
import com.example.help.network.response.Help

class ListingActivity : AppCompatActivity() {
    private val binding: ActivityListingBinding by dataBinding(R.layout.activity_listing)
    private val listingActivityViewModel: ListingActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(...) ve diğer gerekli işlemler

        // ViewModel ve LiveData'yı oluşturun
        val listingActivityViewModel =
            ViewModelProvider(this).get(ListingActivityViewModel::class.java)
        listingActivityViewModel.getAllRequests()

        // LiveData'nın değişikliklerini dinleyin
        listingActivityViewModel.helpListData.observe(this) { helpList ->
            if (helpList != null) {
                val adapter =
                    listingAdapter(helpList, detailClickListener = object : RowClickListener<ListHelp> {
                        override fun onRowClick(pos: Int, item: ListHelp) {
                            Log.d("clicked detail", item.requestDate)
                            // Diğer işlemler
                            val intent = Intent(this@ListingActivity, DetailActivity::class.java)
                            intent.putExtra("quantity",item.requestQuantity)
                            intent.putExtra("type",item.requestType)
                            intent.putExtra("details",item.requestDetails)
                            intent.putExtra("zaman",item.requestTime)
                            startActivity(intent)
                        }
                    })
                binding.listviewrecclerview.adapter = adapter
                binding.listviewrecclerview.layoutManager =
                    LinearLayoutManager(this@ListingActivity)
            } else {
                // helpList null ise yapılacak işlemler
            }
        }
    }
}
//    private fun observeViewModels() {
//
//        listingActivityViewModel.helpListData.observe(this) { helpList ->
//            if (helpList != null) {
//                val adapter = listingAdapter(helpList, detailClickListener = object : RowClickListener<Help> {
//                    override fun onRowClick(pos: Int, item: Help) {
//                        Log.d("clicked detail", item.requestDate)
//                        // Diğer işlemler
//                    }
//                })
//                binding.listviewrecclerview.adapter=adapter
//                binding.listviewrecclerview.layoutManager = LinearLayoutManager(this@ListingActivity)
//
//            } else {
//                // helpList null ise yapılacak işlemler
//            }
//        }
//
//
//    }}
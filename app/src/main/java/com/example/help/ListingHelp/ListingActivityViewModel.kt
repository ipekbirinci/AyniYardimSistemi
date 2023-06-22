package com.example.help.ListingHelp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.help.network.HelpApi
import com.example.help.network.ListResponse.ListHelp
import com.example.help.network.ListResponse.ListResponse
import com.example.help.network.response.Help
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListingActivityViewModel:ViewModel() {
    private val helpList = MutableLiveData<List<ListHelp>>()
    val helpListData: LiveData<List<ListHelp>> get() = helpList

    fun getAllRequests() {
        val call = HelpApi.helpService.getAllRequests()

        call.enqueue(object : Callback<ListResponse> {
            override fun onResponse(call: Call<ListResponse>, response: Response<ListResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.d("DataSize", it.count.toString())
                        //val result = it.result
                        helpList.postValue(it.result)

                    }
                } else {
                    // Handle the error case
                }
            }

            override fun onFailure(call: Call<ListResponse>, t: Throwable) {
                // Handle the failure case
            }
        })
    }
}

package com.example.help.Detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.help.network.HelpApi
import com.example.help.network.ListResponse.ListResponse
import com.example.help.network.response.Help
import com.example.help.network.response.HelpListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivityViewModel: ViewModel() {
   private var _detailData=MutableLiveData<List<Help>>()
    val detailData: LiveData<List<Help>>
        get() = _detailData

    fun getDetail(requestId:String){
        val call = HelpApi.helpService.getDetail(requestId)
        call.enqueue(object : Callback<HelpListResponse> {
            override fun onResponse(call: Call<HelpListResponse>, response: Response<HelpListResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _detailData.postValue(it.result)
                    }
                } else {
                    // Handle the error case
                }
            }

            override fun onFailure(call: Call<HelpListResponse>, t: Throwable) {
                // Handle the failure case
            }
        })


    }
}
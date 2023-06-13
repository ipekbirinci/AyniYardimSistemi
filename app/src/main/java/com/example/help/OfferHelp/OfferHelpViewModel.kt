package com.example.help.OfferHelp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.help.network.HelpApi
import com.example.help.network.data.RequestResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OfferHelpViewModel: ViewModel() {
    val isOfferSuccess = MutableLiveData<RequestResponse>()
    val OfferSuccessData: LiveData<RequestResponse> get() = isOfferSuccess

    fun getRequestByUser(userId: String) {
        val call = HelpApi.helpService.getRequestByUser(userId)

        call.enqueue(object : Callback<RequestResponse> {
            override fun onResponse(call: Call<RequestResponse>, response: Response<RequestResponse>) {
                if (response.isSuccessful) {
                    val requestDataList = response.body()
                    if (requestDataList != null) {
                        // requestDataList'i kullanabilirsiniz
                        // Log.d("deneme","$")
                        isOfferSuccess.value = RequestResponse(requestDataList)

                    }
                } else {
                    // İstek başarısız oldu, hata işleme yapabilirsiniz
                }
            }

            override fun onFailure(call: Call<RequestResponse>, t: Throwable) {
                // İstek başarısız oldu, hata işleme yapabilirsiniz
            }
        })

    }
}
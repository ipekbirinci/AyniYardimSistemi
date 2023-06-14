package com.example.help.OfferHelp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.help.network.HelpApi
import com.example.help.network.data.RequestResponse
import com.example.help.network.data.RequestResponseData
import com.example.help.network.response.Help
import com.example.help.network.response.HelpListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OfferHelpViewModel: ViewModel() {
    val isOfferSuccess = MutableLiveData<RequestResponse>()
    val OfferSuccessData: LiveData<RequestResponse> get() = isOfferSuccess

    private var helpList = MutableLiveData<List<Help>>()
    val helpListData: LiveData<List<Help>> get() = helpList

    fun getRequestByUser(userId: String) {
        val call = HelpApi.helpService.getRequestByUser(userId)

        call.enqueue(object : Callback<HelpListResponse> {
            override fun onResponse(call: Call<HelpListResponse>, response: Response<HelpListResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.d("DataSize", it.count.toString())
                        helpList.postValue(it.result)
                        it.result.forEach { help ->
                            Log.d("DataHelpType", help.requestType)
                        }

                    }



                } else {
                    // İstek başarısız oldu, hata işleme yapabilirsiniz
                }
            }

            override fun onFailure(call: Call<HelpListResponse>, t: Throwable) {
                // İstek başarısız oldu, hata işleme yapabilirsiniz
            }
        })

    }
}
package com.example.help.NewRequest

import android.util.Log
import android.widget.Spinner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.help.network.HelpApi
import com.example.help.network.data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewRequestViewModel: ViewModel() {
    val isRequestSuccess = MutableLiveData<Boolean>()
    val RequestsSuccessData: LiveData<Boolean> get() = isRequestSuccess


    fun createRequest(
        yardimTuru: String,
        // beden: String,
        oncelik: String,
        miktar: String,
        aciklama: String,
        userId: String,
        location: Location

    ){

        val requestData = RequestData(userId,yardimTuru,miktar,aciklama,oncelik,location)
        val createRequestCall = HelpApi.helpService.createRequest(requestData)

        createRequestCall.enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if (response.isSuccessful) {
                    val loggedInUserData = response.body()
                    // Giriş başarılı, loggedInUserData'ya erişebilir
                    Log.d("giriş", "başarılı")
                    loggedInUserData?.let {
                        isRequestSuccess.postValue(it)


                    }


                } else {
                    // Giriş başarısız, hata işleme yap
                    Log.d("giriş", "giriş başarısız")
                }
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                // İstek başarısız, hata işleme yap
                Log.d("giriş","hata: ${t.message}")
            }
        })

    }




}
package com.example.help.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.help.network.HelpApi
import com.example.help.network.data.UserLogin
import com.example.help.network.data.UserRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    private val RegisterSuccess = MutableLiveData<Boolean>()
    val isRegisterSuccessData: LiveData<Boolean> get() = RegisterSuccess

    fun addUser(name:String,phone:String,email:String,password:String) {

        val userData = UserRegister(name, phone, email, password)
        val registerCall = HelpApi.helpService.addUser(userData)


        registerCall.enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if (response.isSuccessful) {
                    val loggedInUserData = response.body()
                    // Giriş başarılı, loggedInUserData'ya erişebilir
                    Log.d("giriş", "başarılı")
                    response.body()?.let {
                        if (it){
                            RegisterSuccess.postValue(true)

                        }
                } }else {
                    // Giriş başarısız, hata işleme yap
                    Log.d("giriş", "giriş başarısız")
                }
            }
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                // İstek başarısız, hata işleme yap
                Log.e("istek", "istek başarısız",t)
            }
        })

    }

}
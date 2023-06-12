package com.example.help.login


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.help.network.HelpApi
import com.example.help.network.data.LoginResponseData
import com.example.help.network.data.UserLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel : ViewModel() {

    private val isLoginSuccess = MutableLiveData<Boolean>()
    val isLoginSuccessData: LiveData<Boolean> get() = isLoginSuccess

    fun login(phone: String, password: String) {
        val userData = UserLogin(phone, password)
        val loginCall = HelpApi.helpService.login(userData)

        loginCall.enqueue(object : Callback<LoginResponseData> {
            override fun onResponse(call: Call<LoginResponseData>, response: Response<LoginResponseData>) {
                if (response.isSuccessful) {
                    val loggedInUserData = response.body()
                    // Giriş başarılı, loggedInUserData'ya erişebilir
                    Log.d("giriş", "başarılı")
                    loggedInUserData?.let {
                        val userId = it.id
                        Log.d("giriş", "userId: $userId")
                        isLoginSuccess.postValue(it.success)
                    }

                } else {
                    // Giriş başarısız, hata işleme yap
                    Log.d("giriş", "giriş başarısız")
                }
            }

            override fun onFailure(call: Call<LoginResponseData>, t: Throwable) {
                // İstek başarısız, hata işleme yap
                Log.d("giriş","hata: ${t.message}")
            }
        })
    }
}

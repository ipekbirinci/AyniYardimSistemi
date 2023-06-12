package com.example.help.network

import com.example.help.network.data.LoginResponseData
import com.example.help.network.data.UserLogin
import com.example.help.network.data.RequestData
import com.example.help.network.data.UserRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HelpService {

    @GET("/requests")
    fun getAllRequests(): Call<MutableList<RequestData>>

    //yeni yardım talebi oluştur
    @POST("/request_create")
   fun createRequest():Call<RequestData>
    //talebi sil
    //talebi düzenle

    //KAYIT OL
    @POST("/users/login")
    fun login(@Body post: UserLogin):Call<LoginResponseData>

    @POST("/users/signup")
    fun addUser(@Body post: UserRegister): Call<Boolean>


}
package com.example.help.network

import com.example.help.network.data.*
import com.example.help.network.response.HelpListResponse
import retrofit2.Call
import retrofit2.http.*

interface HelpService {

    //map listeleme

    //listing ekranı
    @GET("/requests")
    fun getAllRequests(): Call<MutableList<RequestData>>

    //Kullanıcı istekleri
    @GET("/requests/user/{userId}")
    fun getRequestByUser(@Path("userId") userId: String): Call<HelpListResponse>

    //yeni yardım talebi oluştur
    @POST("/requests")
   fun createRequest(@Body post:RequestData):Call<Boolean>

    //talebi sil
   @DELETE("")
   fun deleteRequest(@Path("requestId")requestId:String):Call<HelpListResponse>
    //talebi düzenle

    //KAYIT OL
    @POST("/users/login")
    fun login(@Body post: UserLogin):Call<LoginResponseData>

    @POST("/users/signup")
    fun addUser(@Body post: UserRegister): Call<Boolean>


}
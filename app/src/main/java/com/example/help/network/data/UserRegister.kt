@file:JvmName("LoginDataKt")

package com.example.help.network.data


val userDataList = ArrayList<UserRegister>()


data class UserRegister(
    val name: String,
    val phone: String,
    val email: String,
    val password: String,

)




package com.example.help.network.data

import android.widget.Spinner

val RequestDataList=ArrayList<RequestData>()

data class RequestData(
    val userId: String,
    val requestType: String,
    val requestQuantity: String,
    val requestDetails: String,
    val requestPriorty: String,
    val location: Location,
)
data class Location(
    val X: Int,
    val Y: Int
)

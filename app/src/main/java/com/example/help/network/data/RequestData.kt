package com.example.help.network.data

val RequestDataList=ArrayList<RequestData>()

data class RequestData(
    val userId: String,
    val requestType: String,
    val requestQuantity: Int,
    val requestDetails: String,
    val requestPriorty: String,
    val location: Location,
    val requestDate: String,
    val requestTime: String
)
data class Location(
    val x: Int,
    val y: Int
)

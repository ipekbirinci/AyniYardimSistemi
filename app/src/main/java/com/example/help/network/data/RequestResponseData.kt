package com.example.help.network.data

data class RequestResponse(val data: RequestResponse)

data class RequestResponseData(
    val _id:String,
    val userId: String,
    val requestType: String,
    val requestQuantity: String,
    val requestDetails: String,
    val requestPriorty: String,
    val location: RequestLocation,
    val requestData:String,
    val requestTime:String
)
data class RequestLocation(
    val X: Int,
    val Y: Int
)
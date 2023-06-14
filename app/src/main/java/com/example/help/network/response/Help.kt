package com.example.help.network.response

data class Help(
    val __v: Int,
    val _id: String,
    val location: Location,
    val requestDate: String,
    val requestDetails: String,
    val requestPriority: String,
    val requestQuantity: String,
    val requestTime: String,
    val requestType: String,
    val userId: String
)
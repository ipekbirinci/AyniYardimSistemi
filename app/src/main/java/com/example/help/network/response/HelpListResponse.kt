package com.example.help.network.response

import com.google.gson.annotations.SerializedName

data class HelpListResponse(
    val count: Int,
   val result: List<Help>
)
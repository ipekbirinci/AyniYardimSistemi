package com.example.help.network.response

import com.google.gson.annotations.SerializedName

data class HelpListResponse(
    val count: Int,
  @SerializedName("requests")  val result: List<Help>
)
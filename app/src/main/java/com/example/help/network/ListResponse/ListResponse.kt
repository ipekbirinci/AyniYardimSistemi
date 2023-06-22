package com.example.help.network.ListResponse

import com.google.gson.annotations.SerializedName

data class ListResponse(
    val count: Int,
  @SerializedName("requests")  val result: List<ListHelp>
)
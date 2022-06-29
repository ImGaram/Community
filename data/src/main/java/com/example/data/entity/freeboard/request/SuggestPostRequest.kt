package com.example.data.entity.freeboard.request

import com.google.gson.annotations.SerializedName

data class SuggestPostRequest(
    @SerializedName("user") val user: Int,
    @SerializedName("board") val board: Int
)

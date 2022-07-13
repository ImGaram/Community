package com.example.data.entity.story.request

import com.google.gson.annotations.SerializedName

data class SuggestStoryRequest(
    @SerializedName("user") val user: Int,
    @SerializedName("board") val board: Int
)

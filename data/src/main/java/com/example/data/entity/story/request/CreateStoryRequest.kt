package com.example.data.entity.story.request

import com.google.gson.annotations.SerializedName

data class CreateStoryRequest(
    @SerializedName("title") val title: String,
    @SerializedName("context") val context: String,
    @SerializedName("create_user") val createUser: Int
)

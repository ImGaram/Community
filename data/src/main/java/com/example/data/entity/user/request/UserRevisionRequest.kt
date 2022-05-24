package com.example.data.entity.user.request

import com.google.gson.annotations.SerializedName

data class UserRevisionRequest(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)

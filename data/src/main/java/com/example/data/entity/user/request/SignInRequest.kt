package com.example.data.entity.user.request

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("name") var name: String,
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
)

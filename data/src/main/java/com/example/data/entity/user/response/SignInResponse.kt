package com.example.data.entity.user.response

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
)
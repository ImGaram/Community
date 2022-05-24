package com.example.data.base

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
)
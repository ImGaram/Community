package com.example.data.entity.inquiry.request

import com.google.gson.annotations.SerializedName

data class BaseInquiryRequest(
    @SerializedName("title") val title: String,
    @SerializedName("context") val context: String,
    @SerializedName("create_user_id") val createUserId: Int
)

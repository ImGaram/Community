package com.example.data.entity.freeboard.request

import com.google.gson.annotations.SerializedName

data class ModifyFreeBoardRequest(
    @SerializedName("title") val title: String,
    @SerializedName("context") val context: String,
    @SerializedName("img1") val img1: String,
    @SerializedName("img2") val img2: String,
    @SerializedName("img3") val img3: String,
    @SerializedName("img4") val img4: String,
    @SerializedName("img5") val img5: String,
    @SerializedName("create_user") val createUser: Int
)

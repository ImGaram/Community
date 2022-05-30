package com.example.domain.model.freeboard.addpost

import com.example.domain.model.freeboard.getpost.DomainGetFreeBoardResponse
import com.google.gson.annotations.SerializedName

data class DomainAddFreeBoardResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("context") val context:String,
    @SerializedName("img1") val img1:String,
    @SerializedName("img2") val img2:String,
    @SerializedName("img3") val img3:String,
    @SerializedName("img4") val img4:String,
    @SerializedName("img5") val img5:String,
    @SerializedName("create_user") val createUser: Int,
    @SerializedName("create_date") val createDate: String,
    @SerializedName("correction_date") val correctionDate: String
)
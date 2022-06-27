package com.example.data.entity.freeboard.request

import com.google.gson.annotations.SerializedName

data class BaseCommentRequest(
    @SerializedName("context") val context: String,
    @SerializedName("create_id_user_fr") val createIdUser: Int,
    @SerializedName("comment_NB") val commentPost: Int
)

package com.example.data.entity.story.request

import com.google.gson.annotations.SerializedName

data class CreateCommentRequest(
    @SerializedName("context") val context: String,
    @SerializedName("create_id_user_st") val createIdUserSt: Int,
    @SerializedName("comment_Story") val commentStory: Int
)

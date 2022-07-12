package com.example.data.entity.story.response

import com.example.domain.model.story.DomainBaseCommentResponse
import com.google.gson.annotations.SerializedName

data class BaseCommentResponse(
    @SerializedName("id") val _id: Int,
    @SerializedName("context") val _context: String,
    @SerializedName("create_id_user_st") val _createIdUserSt: Int,
    @SerializedName("comment_Story") val _commentStory: Int,
    @SerializedName("create_date") val _createDate: String,
    @SerializedName("correction_date") val _correctionDate: String
): DomainBaseCommentResponse {
    override val id: Int
        get() = _id
    override val context: String
        get() = _context
    override val createIdUserSt: Int
        get() = _createIdUserSt
    override val commentStory: Int
        get() = _commentStory
    override val createDate: String
        get() = _createDate
    override val correctionDate: String
        get() = _correctionDate

}
package com.example.data.entity.freeboard.response

import com.example.domain.model.freeboard.comment.DomainGetCommentResponse
import com.google.gson.annotations.SerializedName

data class GetCommentResponse(
    @SerializedName("id") val _id: Int,
    @SerializedName("context") val _context: String,
    @SerializedName("create_id_user_fr") val _createIdUser: Int,
    @SerializedName("comment_NB") val _commentPost: Int,
    @SerializedName("create_date") val _createDate: String,
    @SerializedName("correction_date") val _correctionDate: String
): DomainGetCommentResponse {
    override val id: Int
        get() = _id
    override val context: String
        get() = _context
    override val createIdUser: Int
        get() = _createIdUser
    override val commentPost: Int
        get() = _commentPost
    override val createDate: String
        get() = _createDate
    override val correctionDate: String
        get() = _correctionDate

}

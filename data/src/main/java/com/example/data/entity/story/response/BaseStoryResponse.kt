package com.example.data.entity.story.response

import com.example.domain.model.story.DomainBaseStoryResponse
import com.google.gson.annotations.SerializedName

data class BaseStoryResponse(
    @SerializedName("id") val _id: Int,
    @SerializedName("title") val _title: String,
    @SerializedName("context") val _context: String,
    @SerializedName("create_user") val _createUser: Int,
    @SerializedName("create_date") val _createDate: String,
    @SerializedName("correction_date") val _correctionDate: String
): DomainBaseStoryResponse{
    override val id: Int
        get() = _id
    override val title: String
        get() = _title
    override val context: String
        get() = _context
    override val createUser: Int
        get() = _createUser
    override val createDate: String
        get() = _createDate
    override val correctionDate: String
        get() = _correctionDate

}

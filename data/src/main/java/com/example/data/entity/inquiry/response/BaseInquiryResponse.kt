package com.example.data.entity.inquiry.response

import com.example.domain.model.inquiry.DomainBaseInquiryResponse
import com.google.gson.annotations.SerializedName

data class BaseInquiryResponse(
    @SerializedName("id") val _id: Int,
    @SerializedName("title") val _title: String,
    @SerializedName("context") val _context: String,
    @SerializedName("create_user_id") val _createUserId: Int,
    @SerializedName("create_date") val _createDate: String,
    @SerializedName("correction_date") val _correctionDate: String
): DomainBaseInquiryResponse {
    override val id: Int
        get() = _id
    override val title: String
        get() = _title
    override val context: String
        get() = _context
    override val createUserId: Int
        get() = _createUserId
    override val createDate: String
        get() = _createDate
    override val correctionDate: String
        get() = _correctionDate
}


package com.example.data.entity.notice.response

import com.example.domain.model.notice.DomainBaseNoticeResponse
import com.google.gson.annotations.SerializedName

data class BaseNoticeResponse(
    @SerializedName("id") val _id: Int,
    @SerializedName("title") val _title: String,
    @SerializedName("context") val _context: String,
    @SerializedName("img1") val _img1: String,
    @SerializedName("img2") val _img2: String,
    @SerializedName("img3") val _img3: String,
    @SerializedName("create_date") val _createDate: String,
    @SerializedName("correction_date") val _correctionDate: String
): DomainBaseNoticeResponse {
    override val id: Int
        get() = _id
    override val title: String
        get() = _title
    override val context: String
        get() = _context
    override val img1: String
        get() = _img1
    override val img2: String
        get() = _img2
    override val img3: String
        get() = _img3
    override val createDate: String
        get() = _createDate
    override val correctionDate: String
        get() = _correctionDate

}

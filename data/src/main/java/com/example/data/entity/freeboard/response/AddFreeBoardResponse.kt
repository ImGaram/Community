package com.example.data.entity.freeboard.response

import com.example.domain.model.freeboard.getpost.DomainGetAllFreeBoardResponse
import com.google.gson.annotations.SerializedName

data class AddFreeBoardResponse(
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
): DomainGetAllFreeBoardResponse {
    override val _id: Int
        get() = id
    override val _title: String
        get() = title
    override val _context: String
        get() = context
    override val _img1: String
        get() = img1
    override val _img2: String
        get() = img2
    override val _img3: String
        get() = img3
    override val _img4: String
        get() = img4
    override val _img5: String
        get() = img5
    override val _createUser: Int
        get() = createUser
    override val _createDate: String
        get() = createDate
    override val _correctionDate: String
        get() = correctionDate
}

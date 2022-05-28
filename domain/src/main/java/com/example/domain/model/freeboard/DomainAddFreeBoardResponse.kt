package com.example.domain.model.freeboard

data class DomainAddFreeBoardResponse(
    val id: Int,
    val title: String,
    val context:String,
    val img1:String,
    val img2:String,
    val img3:String,
    val img4:String,
    val img5:String,
    val createUser: Int,
    val createDate: String,
    val correctionDate: String
)

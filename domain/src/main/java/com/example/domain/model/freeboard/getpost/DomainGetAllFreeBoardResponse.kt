package com.example.domain.model.freeboard.getpost

interface DomainGetAllFreeBoardResponse {
    val _id: Int
    val _title: String
    val _context:String
    val _img1:String
    val _img2:String
    val _img3:String
    val _img4:String
    val _img5:String
    val _createUser: Int
    val _createDate: String
    val _correctionDate: String
}
package com.example.domain.model.notice

interface DomainBaseNoticeResponse {
    val id: Int
    val title: String
    val context: String
    val img1: String
    val img2: String
    val img3: String
    val createDate: String
    val correctionDate: String
}
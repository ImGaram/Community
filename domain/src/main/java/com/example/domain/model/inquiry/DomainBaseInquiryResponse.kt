package com.example.domain.model.inquiry

interface DomainBaseInquiryResponse {
    val id: Int
    val title: String
    val context: String
    val createUserId: Int
    val createDate: String
    val correctionDate: String
}
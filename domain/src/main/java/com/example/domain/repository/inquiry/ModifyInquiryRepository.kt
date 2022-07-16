package com.example.domain.repository.inquiry

import com.example.domain.model.inquiry.DomainBaseInquiryResponse

interface ModifyInquiryRepository {
    suspend fun modifyInquiry(inquiry: Int, title: String, context: String, createUserId: Int): DomainBaseInquiryResponse?
}
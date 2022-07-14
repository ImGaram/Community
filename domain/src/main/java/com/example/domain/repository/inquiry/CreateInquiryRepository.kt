package com.example.domain.repository.inquiry

import com.example.domain.model.inquiry.DomainBaseInquiryResponse

interface CreateInquiryRepository {
    suspend fun createInquiry(
        title: String,
        context: String,
        createUserId: Int
    ): DomainBaseInquiryResponse?
}
package com.example.domain.repository.inquiry

import com.example.domain.model.inquiry.DomainBaseInquiryResponse

interface GetInquiryRepository {
    suspend fun getInquiry(
        inquiry: Int
    ): DomainBaseInquiryResponse?
}
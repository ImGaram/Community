package com.example.domain.repository.inquiry

import com.example.domain.model.inquiry.DomainBaseInquiryResponse

interface GetInquiryListRepository {
    suspend fun getInquiryList(): List<DomainBaseInquiryResponse>?
}
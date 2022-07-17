package com.example.domain.repository.inquiry

interface DeleteInquiryRepository {
    suspend fun deleteInquiry(inquiry: Int): Int?
}
package com.example.data.datasource.inquiry.remote

interface DeleteInquiryDataSource {
    suspend fun deleteInquiry(inquiry: Int): Int?
}
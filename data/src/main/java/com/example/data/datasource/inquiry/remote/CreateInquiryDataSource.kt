package com.example.data.datasource.inquiry.remote

import com.example.data.entity.inquiry.request.BaseInquiryRequest
import com.example.data.entity.inquiry.response.BaseInquiryResponse

interface CreateInquiryDataSource {
    suspend fun createInquiry(
        body: BaseInquiryRequest
    ): BaseInquiryResponse?
}
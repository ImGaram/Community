package com.example.data.datasource.inquiry.remote

import com.example.data.entity.inquiry.response.BaseInquiryResponse

interface GetInquiryDataSource {
    suspend fun getInquiry(
        inquiry: Int
    ): BaseInquiryResponse?
}
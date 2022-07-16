package com.example.data.datasource.inquiry.remote

import com.example.data.entity.inquiry.request.BaseInquiryRequest
import com.example.data.entity.inquiry.response.BaseInquiryResponse

interface ModifyInquiryDataSource {
    suspend fun modifyInquiry(inquiry: Int, body: BaseInquiryRequest): BaseInquiryResponse?
}
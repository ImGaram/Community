package com.example.data.datasource.inquiry.remote

import com.example.data.entity.inquiry.response.BaseInquiryResponse

interface GetInquiryListDataSource {
    suspend fun getInquiryList(): List<BaseInquiryResponse>?
}
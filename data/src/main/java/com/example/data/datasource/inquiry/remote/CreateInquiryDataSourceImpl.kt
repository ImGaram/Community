package com.example.data.datasource.inquiry.remote

import com.example.data.api.inquiry.CreateInquiryService
import com.example.data.base.BaseDataSource
import com.example.data.entity.inquiry.request.BaseInquiryRequest
import com.example.data.entity.inquiry.response.BaseInquiryResponse
import javax.inject.Inject

class CreateInquiryDataSourceImpl @Inject constructor(
    override val service: CreateInquiryService
): BaseDataSource<CreateInquiryService>(), CreateInquiryDataSource {
    override suspend fun createInquiry(body: BaseInquiryRequest): BaseInquiryResponse? {
        return safeApiCall {
            service.createInquiry(body)
        }?.body()
    }
}
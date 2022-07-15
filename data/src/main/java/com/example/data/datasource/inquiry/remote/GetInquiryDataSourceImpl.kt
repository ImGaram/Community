package com.example.data.datasource.inquiry.remote

import com.example.data.api.inquiry.GetInquiryService
import com.example.data.base.BaseDataSource
import com.example.data.entity.inquiry.response.BaseInquiryResponse
import javax.inject.Inject

class GetInquiryDataSourceImpl @Inject constructor(
    override val service: GetInquiryService
): BaseDataSource<GetInquiryService>(), GetInquiryDataSource {
    override suspend fun getInquiry(inquiry: Int): BaseInquiryResponse? {
        return safeApiCall {
            service.getInquiry(inquiry)
        }?.body()
    }
}
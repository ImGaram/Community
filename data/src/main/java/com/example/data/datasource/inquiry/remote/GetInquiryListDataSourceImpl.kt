package com.example.data.datasource.inquiry.remote

import com.example.data.api.inquiry.GetInquiryListService
import com.example.data.base.BaseDataSource
import com.example.data.entity.inquiry.response.BaseInquiryResponse
import javax.inject.Inject

class GetInquiryListDataSourceImpl @Inject constructor(
    override val service: GetInquiryListService
): BaseDataSource<GetInquiryListService>(), GetInquiryListDataSource {
    override suspend fun getInquiryList(): List<BaseInquiryResponse>? {
        return safeApiCall {
            service.getInquiryList()
        }?.body()
    }
}
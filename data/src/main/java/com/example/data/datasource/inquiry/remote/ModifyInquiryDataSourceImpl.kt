package com.example.data.datasource.inquiry.remote

import com.example.data.api.inquiry.ModifyInquiryService
import com.example.data.base.BaseDataSource
import com.example.data.entity.inquiry.request.BaseInquiryRequest
import com.example.data.entity.inquiry.response.BaseInquiryResponse
import javax.inject.Inject

class ModifyInquiryDataSourceImpl @Inject constructor(
    override val service: ModifyInquiryService
): BaseDataSource<ModifyInquiryService>(), ModifyInquiryDataSource {
    override suspend fun modifyInquiry(inquiry: Int, body: BaseInquiryRequest): BaseInquiryResponse? {
        return safeApiCall {
            service.modifyInquiry(inquiry, body)
        }?.body()
    }
}
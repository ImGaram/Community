package com.example.data.datasource.inquiry.remote

import com.example.data.api.inquiry.DeleteInquiryService
import com.example.data.base.BaseDataSource
import javax.inject.Inject

class DeleteInquiryDataSourceImpl @Inject constructor(
    override val service: DeleteInquiryService
): BaseDataSource<DeleteInquiryService>(), DeleteInquiryDataSource {
    override suspend fun deleteInquiry(inquiry: Int): Int? {
        return safeApiCall {
            service.deleteInquiry(inquiry)
        }?.code()
    }
}
package com.example.data.datasource.inquiry.repositoryimpl

import com.example.data.datasource.inquiry.remote.GetInquiryListDataSource
import com.example.data.entity.inquiry.response.BaseInquiryResponse
import com.example.domain.repository.inquiry.GetInquiryListRepository
import javax.inject.Inject

class GetInquiryListRepositoryImpl @Inject constructor(
    private val dataSource: GetInquiryListDataSource
): GetInquiryListRepository {
    override suspend fun getInquiryList(): List<BaseInquiryResponse>? {
        return dataSource.getInquiryList()
    }
}
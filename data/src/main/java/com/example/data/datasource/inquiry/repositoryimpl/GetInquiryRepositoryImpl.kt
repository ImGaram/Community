package com.example.data.datasource.inquiry.repositoryimpl

import com.example.data.datasource.inquiry.remote.GetInquiryDataSource
import com.example.domain.model.inquiry.DomainBaseInquiryResponse
import com.example.domain.repository.inquiry.GetInquiryRepository
import javax.inject.Inject

class GetInquiryRepositoryImpl @Inject constructor(
    private val dataSource: GetInquiryDataSource
): GetInquiryRepository {
    override suspend fun getInquiry(inquiry: Int): DomainBaseInquiryResponse? {
        return dataSource.getInquiry(inquiry)
    }
}
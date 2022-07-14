package com.example.data.datasource.inquiry.repositoryimpl

import com.example.data.datasource.inquiry.remote.CreateInquiryDataSource
import com.example.data.entity.inquiry.request.BaseInquiryRequest
import com.example.domain.model.inquiry.DomainBaseInquiryResponse
import com.example.domain.repository.inquiry.CreateInquiryRepository
import javax.inject.Inject

class CreateInquiryRepositoryImpl @Inject constructor(
    private val dataSource: CreateInquiryDataSource
): CreateInquiryRepository {
    override suspend fun createInquiry(
        title: String,
        context: String,
        createUserId: Int
    ): DomainBaseInquiryResponse? {
        return dataSource.createInquiry(BaseInquiryRequest(title, context, createUserId))
    }
}
package com.example.data.datasource.inquiry.repositoryimpl

import com.example.data.datasource.inquiry.remote.ModifyInquiryDataSource
import com.example.data.entity.inquiry.request.BaseInquiryRequest
import com.example.domain.model.inquiry.DomainBaseInquiryResponse
import com.example.domain.repository.inquiry.ModifyInquiryRepository
import javax.inject.Inject

class ModifyInquiryRepositoryImpl @Inject constructor(
    private val dataSource: ModifyInquiryDataSource
): ModifyInquiryRepository {
    override suspend fun modifyInquiry(
        inquiry: Int,
        title: String,
        context: String,
        createUserId: Int
    ): DomainBaseInquiryResponse? {
        return dataSource.modifyInquiry(inquiry, BaseInquiryRequest(title, context, createUserId))
    }
}
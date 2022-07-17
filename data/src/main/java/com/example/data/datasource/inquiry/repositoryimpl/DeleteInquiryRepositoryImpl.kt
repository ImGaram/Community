package com.example.data.datasource.inquiry.repositoryimpl

import com.example.data.datasource.inquiry.remote.DeleteInquiryDataSource
import com.example.domain.repository.inquiry.DeleteInquiryRepository
import javax.inject.Inject

class DeleteInquiryRepositoryImpl @Inject constructor(
    private val dataSource: DeleteInquiryDataSource
): DeleteInquiryRepository {
    override suspend fun deleteInquiry(inquiry: Int): Int? {
        return dataSource.deleteInquiry(inquiry)
    }
}
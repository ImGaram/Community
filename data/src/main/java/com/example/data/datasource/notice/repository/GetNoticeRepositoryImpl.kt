package com.example.data.datasource.notice.repository

import com.example.data.datasource.notice.datasource.GetNoticeDataSource
import com.example.domain.model.notice.DomainBaseNoticeResponse
import com.example.domain.repository.notice.GetNoticeRepository
import javax.inject.Inject

class GetNoticeRepositoryImpl @Inject constructor(
    private val dataSource: GetNoticeDataSource
): GetNoticeRepository {
    override suspend fun getNotice(notice: Int): DomainBaseNoticeResponse? {
        return dataSource.getNotice(notice)
    }
}
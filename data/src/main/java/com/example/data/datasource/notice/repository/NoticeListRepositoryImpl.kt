package com.example.data.datasource.notice.repository

import com.example.data.datasource.notice.datasource.NoticeListDataSource
import com.example.domain.model.notice.DomainBaseNoticeResponse
import com.example.domain.repository.notice.NoticeListRepository
import javax.inject.Inject

class NoticeListRepositoryImpl @Inject constructor(
    private val dataSource: NoticeListDataSource
): NoticeListRepository {
    override suspend fun getNoticeList(): List<DomainBaseNoticeResponse>? {
        return dataSource.getNoticeList()
    }
}
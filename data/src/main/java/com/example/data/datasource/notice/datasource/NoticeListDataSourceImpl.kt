package com.example.data.datasource.notice.datasource

import com.example.data.api.notice.NoticeListService
import com.example.data.base.BaseDataSource
import com.example.data.entity.notice.response.BaseNoticeResponse
import javax.inject.Inject

class NoticeListDataSourceImpl @Inject constructor(
    override val service: NoticeListService
): BaseDataSource<NoticeListService>(), NoticeListDataSource {
    override suspend fun getNoticeList(): List<BaseNoticeResponse>? {
        return safeApiCall {
            service.getNoticeList()
        }?.body()
    }
}
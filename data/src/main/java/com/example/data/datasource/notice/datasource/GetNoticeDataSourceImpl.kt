package com.example.data.datasource.notice.datasource

import com.example.data.api.notice.GetNoticeService
import com.example.data.base.BaseDataSource
import com.example.data.entity.notice.response.BaseNoticeResponse
import javax.inject.Inject

class GetNoticeDataSourceImpl @Inject constructor(
    override val service: GetNoticeService
): BaseDataSource<GetNoticeService>(), GetNoticeDataSource {
    override suspend fun getNotice(notice: Int): BaseNoticeResponse? {
        return safeApiCall {
            service.getNotice(notice)
        }?.body()
    }
}
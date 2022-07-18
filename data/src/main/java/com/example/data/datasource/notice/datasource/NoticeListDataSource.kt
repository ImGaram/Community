package com.example.data.datasource.notice.datasource

import com.example.data.entity.notice.response.BaseNoticeResponse

interface NoticeListDataSource {
    suspend fun getNoticeList(): List<BaseNoticeResponse>?
}
package com.example.data.datasource.notice.datasource

import com.example.data.entity.notice.response.BaseNoticeResponse

interface GetNoticeDataSource {
    suspend fun getNotice(notice: Int): BaseNoticeResponse?
}
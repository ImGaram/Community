package com.example.domain.repository.notice

import com.example.domain.model.notice.DomainBaseNoticeResponse

interface NoticeListRepository {
    suspend fun getNoticeList(): List<DomainBaseNoticeResponse>?
}
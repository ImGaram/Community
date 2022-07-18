package com.example.domain.repository.notice

import com.example.domain.model.notice.DomainBaseNoticeResponse

interface GetNoticeRepository {
    suspend fun getNotice(notice: Int): DomainBaseNoticeResponse?
}
package com.example.data.api.notice

import com.example.data.entity.notice.response.BaseNoticeResponse
import retrofit2.Response
import retrofit2.http.GET

interface NoticeListService {
    @GET("/Noti/")
    suspend fun getNoticeList(): Response<List<BaseNoticeResponse>>
}
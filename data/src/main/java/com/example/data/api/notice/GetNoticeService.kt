package com.example.data.api.notice

import com.example.data.entity.notice.response.BaseNoticeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetNoticeService {
    @GET("/Noti/{notice}")
    suspend fun getNotice(@Path("notice") notice: Int): Response<BaseNoticeResponse>
}
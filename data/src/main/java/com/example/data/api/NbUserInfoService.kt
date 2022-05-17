package com.example.data.api

import com.example.data.entity.user.response.UserInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NbUserInfoService {
    @GET("/User/{pk}")
    fun getUser(@Query("pk") pk: Int): Response<UserInfoResponse>
}
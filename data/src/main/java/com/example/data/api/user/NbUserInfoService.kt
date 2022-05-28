package com.example.data.api.user

import com.example.data.entity.user.response.UserInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NbUserInfoService {
    @GET("/User/{id}")
    suspend fun getUser(@Path("id") pk: Int): Response<UserInfoResponse>
}
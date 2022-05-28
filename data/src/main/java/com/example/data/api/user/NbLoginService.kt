package com.example.data.api.user

import com.example.data.entity.user.request.LoginRequest
import com.example.data.entity.user.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NbLoginService {
    @POST("/login/")
    suspend fun loginService(
        @Body user: LoginRequest
    ): Response<LoginResponse>
}
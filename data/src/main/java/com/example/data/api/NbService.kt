package com.example.data.api

import com.example.data.entity.request.SignInRequest
import com.example.data.entity.response.SignInResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NbService {
    @POST("/User/")
    suspend fun signInService(
        @Body body: SignInRequest
    ): Response<SignInResponse>
}
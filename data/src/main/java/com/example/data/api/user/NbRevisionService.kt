package com.example.data.api.user

import com.example.data.base.BaseResponse
import com.example.data.entity.user.request.UserRevisionRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path

interface NbRevisionService {
    @PUT("/User/{pk}")
    suspend fun revisionUser(
        @Path("pk") pk: Int,
        @Body body: UserRevisionRequest
    ): Response<BaseResponse>
}
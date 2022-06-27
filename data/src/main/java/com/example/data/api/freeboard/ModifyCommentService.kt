package com.example.data.api.freeboard

import com.example.data.entity.freeboard.request.BaseCommentRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path

interface ModifyCommentService {
    @PUT("/CFR/DE/{pk}")
    suspend fun modifyComment(
        @Path("pk") pk: Int,
        @Body body: BaseCommentRequest
    ): Response<Int>
}
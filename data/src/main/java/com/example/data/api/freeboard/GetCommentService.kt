package com.example.data.api.freeboard

import com.example.data.entity.freeboard.response.GetCommentResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetCommentService {
    @GET("/CFR/{postId}")
    suspend fun getComment(
        @Path("postId") postId: Int
    ): Response<List<GetCommentResponse>>
}
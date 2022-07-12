package com.example.data.api.story.comment

import com.example.data.entity.story.response.BaseCommentResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetCommentListService {
    @GET("/CST/{story}")
    suspend fun getCommentList(
        @Path("story") story: Int
    ): Response<List<BaseCommentResponse>>
}
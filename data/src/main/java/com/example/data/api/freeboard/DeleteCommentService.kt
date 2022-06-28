package com.example.data.api.freeboard

import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Path

interface DeleteCommentService {
    @DELETE("/CFR/DE/{comment}")
    suspend fun deleteComment(
        @Path("comment") comment: Int
    ): Response<Int>
}
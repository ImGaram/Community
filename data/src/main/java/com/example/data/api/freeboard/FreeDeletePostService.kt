package com.example.data.api.freeboard

import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Path

interface FreeDeletePostService {
    @DELETE("/FBN/{pk}")
    suspend fun deletePost(
        @Path("pk") pk: Int
    ): Response<Int>
}
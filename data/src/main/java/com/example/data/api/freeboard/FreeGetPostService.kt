package com.example.data.api.freeboard

import com.example.data.entity.freeboard.response.BaseFreeBoardResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FreeGetPostService {
    @GET("/FBN/{id}")
    suspend fun getPostSingle(
        @Path("id") id: Int
    ): Response<BaseFreeBoardResponse>
}
package com.example.data.api.freeboard

import com.example.data.entity.freeboard.request.AddFreeBoardRequest
import com.example.data.entity.freeboard.response.BaseFreeBoardResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface FreeAddPostService {
    @POST("/FBN/CRE/")
    suspend fun createPost(@Body body: AddFreeBoardRequest): Response<BaseFreeBoardResponse>
}
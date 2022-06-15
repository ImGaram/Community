package com.example.data.api.freeboard

import com.example.data.entity.freeboard.response.BaseFreeBoardResponse
import retrofit2.http.GET

interface FreeGetPostAllService {
    @GET("/FBN/")
    suspend fun getPost(): List<BaseFreeBoardResponse>
}
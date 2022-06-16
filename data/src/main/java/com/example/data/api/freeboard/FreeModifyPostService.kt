package com.example.data.api.freeboard

import com.example.data.entity.freeboard.request.ModifyFreeBoardRequest
import com.example.data.entity.freeboard.response.BaseFreeBoardResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path

interface FreeModifyPostService {
    @PUT("/FBN/{id}")
    suspend fun modifyPost(
        @Body body: ModifyFreeBoardRequest,
        @Path("id") id: Int
    ): Response<BaseFreeBoardResponse>
}

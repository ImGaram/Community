package com.example.data.datasource.freeboard.remote

import com.example.data.entity.freeboard.request.AddFreeBoardRequest
import com.example.data.entity.freeboard.response.AddFreeBoardResponse

interface AddPostDataSource {
    suspend fun createPost(
        body: AddFreeBoardRequest
    ): AddFreeBoardResponse?
}
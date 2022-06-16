package com.example.data.datasource.freeboard.remote.addpost

import com.example.data.entity.freeboard.request.AddFreeBoardRequest
import com.example.data.entity.freeboard.request.ModifyFreeBoardRequest
import com.example.data.entity.freeboard.response.BaseFreeBoardResponse

interface AddPostDataSource {
    suspend fun createPost(
        body: ModifyFreeBoardRequest
    ): BaseFreeBoardResponse?
}
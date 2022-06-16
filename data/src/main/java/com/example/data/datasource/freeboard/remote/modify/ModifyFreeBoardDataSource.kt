package com.example.data.datasource.freeboard.remote.modify

import com.example.data.entity.freeboard.request.ModifyFreeBoardRequest
import com.example.data.entity.freeboard.response.BaseFreeBoardResponse

interface ModifyFreeBoardDataSource {
    suspend fun modifyPost(
        body: ModifyFreeBoardRequest,
        id: Int
    ): BaseFreeBoardResponse?
}
package com.example.data.datasource.freeboard.remote.getpost

import com.example.data.entity.freeboard.response.BaseFreeBoardResponse

interface GetPostDataSource {
    suspend fun getPostSingle(id: Int): BaseFreeBoardResponse?
}
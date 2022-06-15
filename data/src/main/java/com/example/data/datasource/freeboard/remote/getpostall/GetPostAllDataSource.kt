package com.example.data.datasource.freeboard.remote.getpostall

import com.example.data.entity.freeboard.response.BaseFreeBoardResponse

interface GetPostAllDataSource {
    suspend fun getPost(): List<BaseFreeBoardResponse>?
}
package com.example.data.datasource.freeboard.remote.getpost

import com.example.data.entity.freeboard.response.AddFreeBoardResponse

interface GetPostAllDataSource {
    suspend fun getPost(): List<AddFreeBoardResponse>?
}
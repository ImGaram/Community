package com.example.data.datasource.freeboard.remote.getpost

import com.example.data.entity.freeboard.response.AddFreeBoardResponse

interface GetPostDataSource {
    suspend fun getPost(): List<AddFreeBoardResponse>?
}
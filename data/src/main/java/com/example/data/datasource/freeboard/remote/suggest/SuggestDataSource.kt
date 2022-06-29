package com.example.data.datasource.freeboard.remote.suggest

import com.example.data.entity.freeboard.request.SuggestPostRequest

interface SuggestDataSource {
    suspend fun suggestPost(
        body: SuggestPostRequest
    ): Int?
}
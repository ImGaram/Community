package com.example.data.datasource.freeboard.remote.suggest

interface GetSuggestDataSource {
    suspend fun getSuggest(
        board: Int
    ): Int?
}
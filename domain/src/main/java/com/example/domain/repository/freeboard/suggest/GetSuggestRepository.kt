package com.example.domain.repository.freeboard.suggest

interface GetSuggestRepository {
    suspend fun getSuggest(
        board: Int
    ): Int?
}
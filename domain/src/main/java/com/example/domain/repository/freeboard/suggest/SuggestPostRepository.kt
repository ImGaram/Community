package com.example.domain.repository.freeboard.suggest

interface SuggestPostRepository {
    suspend fun suggestPost(
        user: Int,
        board: Int
    ): Int?
}
package com.example.data.datasource.freeboard.repositoryimpl.suggest

import com.example.data.datasource.freeboard.remote.suggest.SuggestDataSource
import com.example.data.entity.freeboard.request.SuggestPostRequest
import com.example.domain.repository.freeboard.suggest.SuggestPostRepository
import javax.inject.Inject

class SuggestPostRepositoryImpl @Inject constructor(
    private val dataSource: SuggestDataSource
): SuggestPostRepository{
    override suspend fun suggestPost(user: Int, board: Int): Int? {
        return dataSource.suggestPost(SuggestPostRequest(user, board))
    }
}
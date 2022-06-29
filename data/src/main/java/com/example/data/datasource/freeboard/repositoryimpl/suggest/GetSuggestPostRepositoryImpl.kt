package com.example.data.datasource.freeboard.repositoryimpl.suggest

import com.example.data.datasource.freeboard.remote.suggest.GetSuggestDataSource
import com.example.domain.repository.freeboard.suggest.GetSuggestRepository
import javax.inject.Inject

class GetSuggestPostRepositoryImpl @Inject constructor(
    private val dataSource: GetSuggestDataSource
): GetSuggestRepository {
    override suspend fun getSuggest(board: Int): Int? {
        return dataSource.getSuggest(board)
    }
}
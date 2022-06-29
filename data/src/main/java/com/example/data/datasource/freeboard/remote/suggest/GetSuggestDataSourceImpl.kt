package com.example.data.datasource.freeboard.remote.suggest

import com.example.data.api.freeboard.GetSuggestService
import com.example.data.base.BaseDataSource
import javax.inject.Inject

class GetSuggestDataSourceImpl @Inject constructor(
    override val service: GetSuggestService
): BaseDataSource<GetSuggestService>(), GetSuggestDataSource {
    override suspend fun getSuggest(board: Int): Int? {
        return safeApiCall {
            service.getSuggest(board)
        }?.body()
    }
}
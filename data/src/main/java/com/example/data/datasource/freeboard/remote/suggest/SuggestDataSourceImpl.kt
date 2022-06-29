package com.example.data.datasource.freeboard.remote.suggest

import com.example.data.api.freeboard.SuggestService
import com.example.data.base.BaseDataSource
import com.example.data.entity.freeboard.request.SuggestPostRequest
import javax.inject.Inject

class SuggestDataSourceImpl @Inject constructor(
    override val service: SuggestService
): BaseDataSource<SuggestService>(), SuggestDataSource {
    override suspend fun suggestPost(body: SuggestPostRequest): Int? {
        return safeApiCall {
            service.suggestPost(body)
        }?.code()
    }
}
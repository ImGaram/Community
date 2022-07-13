package com.example.data.datasource.story.datasource.comment

import com.example.data.api.story.comment.GetSuggestService
import com.example.data.base.BaseDataSource
import javax.inject.Inject

class GetSuggestDataSourceImpl @Inject constructor(
    override val service: GetSuggestService
): BaseDataSource<GetSuggestService>(), GetSuggestDataSource {
    override suspend fun getSuggest(story: Int): Int? {
        return safeApiCall {
            service.getSuggest(story)
        }?.body()
    }
}
package com.example.data.datasource.freeboard.remote.addpost

import com.example.data.api.freeboard.FreeAddPostService
import com.example.data.base.BaseDataSource
import com.example.data.entity.freeboard.request.AddFreeBoardRequest
import com.example.data.entity.freeboard.response.AddFreeBoardResponse
import javax.inject.Inject

class AddPostDataSourceImpl @Inject constructor(
    override val service: FreeAddPostService
): BaseDataSource<FreeAddPostService>(), AddPostDataSource {
    override suspend fun createPost(
        body: AddFreeBoardRequest
    ): AddFreeBoardResponse? {
        return safeApiCall {
            service.createPost(body)
        }?.body()
    }
}
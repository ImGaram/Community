package com.example.data.datasource.freeboard.remote.getpost

import com.example.data.api.freeboard.FreeGetPostService
import com.example.data.base.BaseDataSource
import com.example.data.entity.freeboard.response.AddFreeBoardResponse
import javax.inject.Inject

class GetPostDataSourceImpl @Inject constructor(
    override val service: FreeGetPostService
): BaseDataSource<FreeGetPostService>(), GetPostDataSource {
    override suspend fun getPost(): List<AddFreeBoardResponse> {
        return service.getPost()
    }
}
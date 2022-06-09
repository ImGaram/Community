package com.example.data.datasource.freeboard.remote.getpost

import com.example.data.api.freeboard.FreeGetPostAllService
import com.example.data.base.BaseDataSource
import com.example.data.entity.freeboard.response.AddFreeBoardResponse
import javax.inject.Inject

class GetPostAllDataSourceImpl @Inject constructor(
    override val service: FreeGetPostAllService
): BaseDataSource<FreeGetPostAllService>(), GetPostAllDataSource {
    override suspend fun getPost(): List<AddFreeBoardResponse> {
        return service.getPost()
    }
}
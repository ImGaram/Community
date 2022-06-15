package com.example.data.datasource.freeboard.remote.getpostall

import com.example.data.api.freeboard.FreeGetPostAllService
import com.example.data.base.BaseDataSource
import com.example.data.entity.freeboard.response.BaseFreeBoardResponse
import javax.inject.Inject

class GetPostAllDataSourceImpl @Inject constructor(
    override val service: FreeGetPostAllService
): BaseDataSource<FreeGetPostAllService>(), GetPostAllDataSource {
    override suspend fun getPost(): List<BaseFreeBoardResponse> {
        return service.getPost()
    }
}
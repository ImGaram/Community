package com.example.data.datasource.freeboard.remote.modify

import com.example.data.api.freeboard.FreeModifyPostService
import com.example.data.base.BaseDataSource
import com.example.data.entity.freeboard.request.ModifyFreeBoardRequest
import com.example.data.entity.freeboard.response.BaseFreeBoardResponse
import javax.inject.Inject

class ModifyFreeBoardDatasourceImpl @Inject constructor(
    override val service: FreeModifyPostService
): BaseDataSource<FreeModifyPostService>(), ModifyFreeBoardDataSource {
    override suspend fun modifyPost(body: ModifyFreeBoardRequest, id: Int): BaseFreeBoardResponse? {
        return safeApiCall {
            service.modifyPost(body, id)
        }?.body()
    }
}
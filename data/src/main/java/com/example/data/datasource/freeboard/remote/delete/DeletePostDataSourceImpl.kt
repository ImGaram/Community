package com.example.data.datasource.freeboard.remote.delete

import com.example.data.api.freeboard.FreeDeletePostService
import com.example.data.base.BaseDataSource
import javax.inject.Inject

class DeletePostDataSourceImpl @Inject constructor(
    override val service: FreeDeletePostService
): BaseDataSource<FreeDeletePostService>(), DeletePostDataSource {
    override suspend fun deletePost(pk: Int): Int {
        return safeApiCall {
            service.deletePost(pk)
        }!!.code()
    }
}
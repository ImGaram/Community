package com.example.data.datasource.freeboard.remote.comment

import com.example.data.api.freeboard.ModifyCommentService
import com.example.data.base.BaseDataSource
import com.example.data.entity.freeboard.request.BaseCommentRequest
import javax.inject.Inject

class ModifyCommentDataSourceImpl @Inject constructor(
    override val service: ModifyCommentService
): BaseDataSource<ModifyCommentService>(), ModifyCommentDataSource{
    override suspend fun modifyComment(pk: Int, body: BaseCommentRequest): Int? {
        return safeApiCall {
            service.modifyComment(pk, body)
        }?.code()
    }
}
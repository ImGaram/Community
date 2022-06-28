package com.example.data.datasource.freeboard.remote.comment

import com.example.data.api.freeboard.DeleteCommentService
import com.example.data.base.BaseDataSource
import javax.inject.Inject

class DeleteCommentDataSourceImpl @Inject constructor(
    override val service: DeleteCommentService
): BaseDataSource<DeleteCommentService>(), DeleteCommentDataSource{
    override suspend fun deleteComment(postId: Int): Int? {
        return safeApiCall {
            service.deleteComment(postId)
        }?.code()
    }
}
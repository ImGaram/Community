package com.example.data.datasource.freeboard.repositoryimpl.delete

import com.example.data.datasource.freeboard.remote.delete.DeletePostDataSource
import com.example.domain.repository.freeboard.delete.DeletePostRepository
import javax.inject.Inject

class DeletePostRepositoryImpl @Inject constructor(
    private val dataSource: DeletePostDataSource
): DeletePostRepository{
    override suspend fun deletePost(pk: Int): Int {
        return dataSource.deletePost(pk)
    }
}
package com.example.data.repository.user.repositoryimpl.delete

import com.example.data.repository.user.remote.delete.DeleteUserDataSource
import com.example.domain.repository.user.delete.DeleteUserRepository
import javax.inject.Inject

class DeleteRepositoryImpl @Inject constructor(
    private val dataSource: DeleteUserDataSource
): DeleteUserRepository {
    override suspend fun delete(pk: Int): Int? {
        return dataSource.delete(pk)
    }
}
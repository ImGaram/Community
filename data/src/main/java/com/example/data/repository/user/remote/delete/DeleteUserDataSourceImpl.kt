package com.example.data.repository.user.remote.delete

import com.example.data.api.NbDeleteUserService
import com.example.data.base.BaseDataSource
import javax.inject.Inject

class DeleteUserDataSourceImpl @Inject constructor(
    override val service: NbDeleteUserService
): BaseDataSource<NbDeleteUserService>(), DeleteUserDataSource {
    override suspend fun delete(pk: Int): Int? {
        return safeApiCall {
            service.deleteUser(pk)
        }?.body()
    }
}
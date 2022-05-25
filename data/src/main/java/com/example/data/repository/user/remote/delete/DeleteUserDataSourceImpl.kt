package com.example.data.repository.user.remote.delete

import com.example.data.ApiClient
import com.example.data.api.NbDeleteUserService
import com.example.data.base.BaseDataSource
import okhttp3.ResponseBody
import javax.inject.Inject

class DeleteUserDataSourceImpl @Inject constructor(
    override val service: NbDeleteUserService
): BaseDataSource<NbDeleteUserService>(), DeleteUserDataSource {
    override suspend fun delete(pk: Int): ResponseBody? {
        val serviceCall = service.deleteUser(pk)
        ApiClient.resultCode = serviceCall.code()
        return safeApiCall {
            serviceCall
        }?.body()
    }
}
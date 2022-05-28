package com.example.data.datasource.user.remote.revision

import com.example.data.api.user.NbRevisionService
import com.example.data.base.BaseDataSource
import com.example.data.base.BaseResponse
import com.example.data.entity.user.request.UserRevisionRequest
import javax.inject.Inject

class RevisionDataSourceImpl @Inject constructor(
    override val service: NbRevisionService
): BaseDataSource<NbRevisionService>(), RevisionDataSource {
    override suspend fun revision(
        id: Int,
        body: UserRevisionRequest
    ): BaseResponse? {
        return safeApiCall {
            service.revisionUser(id, body)
        }?.body()
    }
}
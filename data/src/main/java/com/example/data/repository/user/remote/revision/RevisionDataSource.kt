package com.example.data.repository.user.remote.revision

import com.example.data.base.BaseResponse
import com.example.data.entity.user.request.UserRevisionRequest

interface RevisionDataSource {
    suspend fun revision(
        id: Int,
        body: UserRevisionRequest
    ): BaseResponse?
}
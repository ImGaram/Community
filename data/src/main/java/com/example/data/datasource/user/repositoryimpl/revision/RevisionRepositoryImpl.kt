package com.example.data.datasource.user.repositoryimpl.revision

import com.example.data.entity.user.request.UserRevisionRequest
import com.example.data.mapper.Mapper
import com.example.data.datasource.user.remote.revision.RevisionDataSource
import com.example.domain.model.base.DomainBaseResponse
import com.example.domain.repository.user.revision.RevisionRepository
import javax.inject.Inject

class RevisionRepositoryImpl @Inject constructor(
    private val dataSource: RevisionDataSource
): RevisionRepository {
    override suspend fun revision(
        id: Int,
        name: String,
        email: String,
        password: String
    ): DomainBaseResponse? {
        return Mapper.toDomainBaseResponse(dataSource.revision(id, UserRevisionRequest(name, email, password)))
    }
}
package com.example.data.datasource.freeboard.repositoryimpl.getpost

import com.example.data.datasource.freeboard.remote.getpost.GetPostAllDataSource
import com.example.domain.model.freeboard.getpost.DomainGetAllFreeBoardResponse
import com.example.domain.repository.freeboard.getpost.GetPostAllRepository
import javax.inject.Inject

class GetPostAllRepositoryImpl @Inject constructor(
    private val dataSource: GetPostAllDataSource
): GetPostAllRepository {
    override suspend fun getPost(): List<DomainGetAllFreeBoardResponse>? {
        return dataSource.getPost()
//        return FreeBoardMapper.toListDomainAddFreeBoardResponse()
    }
}
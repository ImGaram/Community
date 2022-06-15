package com.example.data.datasource.freeboard.repositoryimpl.getpostall

import com.example.data.datasource.freeboard.remote.getpostall.GetPostAllDataSource
import com.example.domain.model.freeboard.getpostall.DomainGetAllFreeBoardResponse
import com.example.domain.repository.freeboard.getpostall.GetPostAllRepository
import javax.inject.Inject

class GetPostAllRepositoryImpl @Inject constructor(
    private val dataSource: GetPostAllDataSource
): GetPostAllRepository {
    override suspend fun getPost(): List<DomainGetAllFreeBoardResponse>? {
        return dataSource.getPost()
//        return FreeBoardMapper.toListDomainAddFreeBoardResponse()
    }
}
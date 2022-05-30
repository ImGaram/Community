package com.example.data.datasource.freeboard.repositoryimpl.getpost

import com.example.data.datasource.freeboard.remote.getpost.GetPostDataSource
import com.example.domain.model.freeboard.getpost.DomainGetFreeBoardResponse
import com.example.domain.repository.freeboard.getpost.GetPostRepository
import javax.inject.Inject

class GetPostRepositoryImpl @Inject constructor(
    private val dataSource: GetPostDataSource
): GetPostRepository {
    override suspend fun getPost(): List<DomainGetFreeBoardResponse>? {
        return dataSource.getPost()
//        return FreeBoardMapper.toListDomainAddFreeBoardResponse()
    }
}
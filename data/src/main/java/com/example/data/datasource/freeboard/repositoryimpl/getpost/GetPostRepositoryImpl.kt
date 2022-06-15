package com.example.data.datasource.freeboard.repositoryimpl.getpost

import com.example.data.datasource.freeboard.remote.getpost.GetPostDataSource
import com.example.data.mapper.FreeBoardMapper
import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse
import com.example.domain.repository.freeboard.getpost.GetPostRepository
import javax.inject.Inject

class GetPostRepositoryImpl @Inject constructor(
    private val dataSource: GetPostDataSource
): GetPostRepository {
    override suspend fun getPostSingle(
        id: Int
    ): DomainBaseFreeBoardResponse? {
        return FreeBoardMapper.toDomainBaseFreeBoardResponse(dataSource.getPostSingle(id))
    }
}
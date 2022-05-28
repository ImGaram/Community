package com.example.data.datasource.freeboard.repositoryimpl

import com.example.data.datasource.freeboard.remote.AddPostDataSource
import com.example.data.entity.freeboard.request.AddFreeBoardRequest
import com.example.data.mapper.FreeBoardMapper
import com.example.domain.model.freeboard.DomainAddFreeBoardResponse
import com.example.domain.repository.freeboard.AddPostRepository
import javax.inject.Inject

class AddPostRepositoryImpl @Inject constructor(
    private val dataSource: AddPostDataSource
): AddPostRepository {
    override suspend fun createPost(
        title: String,
        context: String,
        img1: String,
        img2: String,
        img3: String,
        img4: String,
        img5: String,
        createUser: Int
    ): DomainAddFreeBoardResponse? {
        return FreeBoardMapper.toDomainAddFreeBoardResponse(dataSource.createPost(
            AddFreeBoardRequest(title, context, img1, img2, img3, img4, img5, createUser)
        ))
    }
}
package com.example.data.datasource.freeboard.repositoryimpl.addpost

import com.example.data.datasource.freeboard.remote.addpost.AddPostDataSource
import com.example.data.entity.freeboard.request.AddFreeBoardRequest
import com.example.data.mapper.FreeBoardMapper
import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse
import com.example.domain.repository.freeboard.addpost.AddPostRepository
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
    ): DomainBaseFreeBoardResponse? {
        return FreeBoardMapper.toDomainBaseFreeBoardResponse(dataSource.createPost(
            AddFreeBoardRequest(title, context, img1, img2, img3, img4, img5, createUser)
        ))
    }
}
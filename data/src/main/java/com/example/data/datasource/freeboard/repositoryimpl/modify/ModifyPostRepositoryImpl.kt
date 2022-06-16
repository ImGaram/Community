package com.example.data.datasource.freeboard.repositoryimpl.modify

import com.example.data.datasource.freeboard.remote.modify.ModifyFreeBoardDataSource
import com.example.data.entity.freeboard.request.ModifyFreeBoardRequest
import com.example.data.mapper.FreeBoardMapper
import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse
import com.example.domain.repository.freeboard.modify.ModifyPostRepository
import javax.inject.Inject

class ModifyPostRepositoryImpl @Inject constructor(
    private val dataSource: ModifyFreeBoardDataSource
): ModifyPostRepository {
    override suspend fun modifyPost(
        title: String,
        context: String,
        img1: String,
        img2: String,
        img3: String,
        img4: String,
        img5: String,
        createUser: Int,
        id: Int
    ): DomainBaseFreeBoardResponse? {
        return FreeBoardMapper.toDomainBaseFreeBoardResponse(
            dataSource.modifyPost(ModifyFreeBoardRequest(title, context, img1, img2, img3, img4, img5, createUser), id))
    }
}
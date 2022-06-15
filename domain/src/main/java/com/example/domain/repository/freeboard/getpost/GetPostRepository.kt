package com.example.domain.repository.freeboard.getpost

import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse

interface GetPostRepository {
    suspend fun getPostSingle(
        id: Int
    ): DomainBaseFreeBoardResponse?
}
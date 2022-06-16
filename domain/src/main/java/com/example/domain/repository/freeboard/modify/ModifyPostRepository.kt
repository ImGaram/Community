package com.example.domain.repository.freeboard.modify

import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse

interface ModifyPostRepository {
    suspend fun modifyPost(
        title: String,
        context: String,
        img1: String,
        img2: String,
        img3: String,
        img4: String,
        img5: String,
        createUser: Int,
        id: Int
    ): DomainBaseFreeBoardResponse?
}
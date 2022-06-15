package com.example.domain.repository.freeboard.addpost

import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse

interface AddPostRepository {
    suspend fun createPost(
        title: String,
        context:String,
        img1:String,
        img2:String,
        img3:String,
        img4:String,
        img5:String,
        createUser: Int
    ): DomainBaseFreeBoardResponse?
}
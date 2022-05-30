package com.example.domain.repository.freeboard.getpost

import com.example.domain.model.freeboard.getpost.DomainGetFreeBoardResponse

interface GetPostRepository {
    suspend fun getPost(): List<DomainGetFreeBoardResponse>?
}
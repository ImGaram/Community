package com.example.domain.repository.freeboard.getpost

import com.example.domain.model.freeboard.getpost.DomainGetAllFreeBoardResponse

interface GetPostAllRepository {
    suspend fun getPost(): List<DomainGetAllFreeBoardResponse>?
}
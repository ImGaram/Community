package com.example.domain.repository.freeboard.getpostall

import com.example.domain.model.freeboard.getpostall.DomainGetAllFreeBoardResponse

interface GetPostAllRepository {
    suspend fun getPost(): List<DomainGetAllFreeBoardResponse>?
}
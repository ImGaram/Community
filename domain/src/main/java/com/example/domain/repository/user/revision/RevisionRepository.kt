package com.example.domain.repository.user.revision

import com.example.domain.model.base.DomainBaseResponse
import com.example.domain.model.user.DomainLoginResponse

interface RevisionRepository {
    suspend fun revision(
        id: Int,
        name: String,
        email: String,
        password: String
    ): DomainBaseResponse?
}
package com.example.domain.model.user

data class DomainUserInfoResponse(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)

package com.example.domain.model.user

data class DomainSignInResponse(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
)
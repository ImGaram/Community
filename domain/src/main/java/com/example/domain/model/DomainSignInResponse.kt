package com.example.domain.model

data class DomainSignInResponse(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
)

//interface DomainSignInResponse {
//    val id: String
//    val name: String
//    val email: String
//    val password: String
//}
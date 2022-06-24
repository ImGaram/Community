package com.example.domain.model.freeboard.comment

interface DomainGetCommentResponse {
    val id: Int
    val context: String
    val createIdUser: Int
    val commentPost: Int
    val createDate: String
    val correctionDate: String
}
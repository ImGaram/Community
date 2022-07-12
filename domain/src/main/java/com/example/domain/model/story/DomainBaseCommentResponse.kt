package com.example.domain.model.story

interface DomainBaseCommentResponse {
    val id: Int
    val context: String
    val createIdUserSt: Int
    val commentStory: Int
    val createDate: String
    val correctionDate: String
}
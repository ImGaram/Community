package com.example.domain.model.story

interface DomainBaseStoryResponse {
    val id: Int
    val title: String
    val context: String
    val createUser: Int
    val createDate: String
    val correctionDate: String
}
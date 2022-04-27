package com.example.data.mapper

import com.example.data.entity.response.SignInResponse
import com.example.domain.model.DomainSignInResponse

object SignInMapper {
    // data -> domain
    fun SignInResponse.toDomain():DomainSignInResponse {
        return DomainSignInResponse(
            this.id,
            this.name,
            this.email,
            this.password
        )
    }
}

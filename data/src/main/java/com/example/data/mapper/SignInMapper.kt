package com.example.data.mapper

import com.example.data.entity.response.SignInResponse
import com.example.domain.model.DomainSignInResponse
import retrofit2.Response

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

    fun toDomainResponse(
        dataResponse: SignInResponse?
    ): DomainSignInResponse? {
        return if (dataResponse != null) {
            DomainSignInResponse(
                id = dataResponse.id,
                email = dataResponse.email,
                name = dataResponse.name,
                password = dataResponse.password
            )
        } else dataResponse
    }
}

package com.example.data.mapper

import com.example.data.entity.user.response.LoginResponse
import com.example.data.entity.user.response.SignInResponse
import com.example.domain.model.user.DomainLoginResponse
import com.example.domain.model.user.DomainSignInResponse

object Mapper {
    // data -> domain
    fun toDomainSignInResponse(
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

    fun toDomainLogInResponse(
        dataResponse: LoginResponse?
    ): DomainLoginResponse? {
        return if (dataResponse != null) {
            DomainLoginResponse(
                id = dataResponse.id,
                email = dataResponse.email,
                name = dataResponse.name,
                password = dataResponse.password
            )
        } else dataResponse
    }
}

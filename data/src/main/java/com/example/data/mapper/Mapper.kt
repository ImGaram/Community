package com.example.data.mapper

import com.example.data.base.BaseResponse
import com.example.data.entity.user.response.LoginResponse
import com.example.data.entity.user.response.SignInResponse
import com.example.data.entity.user.response.UserInfoResponse
import com.example.domain.model.base.DomainBaseResponse
import com.example.domain.model.user.DomainLoginResponse
import com.example.domain.model.user.DomainSignInResponse
import com.example.domain.model.user.DomainUserInfoResponse

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

    fun toDomainUserInfoResponse(
        dataResponse: UserInfoResponse?
    ): DomainUserInfoResponse? {
        return if (dataResponse != null) {
            DomainUserInfoResponse(
                id = dataResponse.id,
                name = dataResponse.name,
                email = dataResponse.email,
                password = dataResponse.password
            )
        } else dataResponse
    }

    fun toDomainBaseResponse(
        dataResponse: BaseResponse?
    ): DomainBaseResponse? {
        return if (dataResponse != null) {
            DomainBaseResponse(
                id = dataResponse.id,
                name = dataResponse.name,
                email = dataResponse.email,
                password = dataResponse.password
            )
        } else dataResponse
    }
}

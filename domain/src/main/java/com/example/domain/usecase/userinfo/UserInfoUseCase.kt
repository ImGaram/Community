package com.example.domain.usecase.userinfo

import com.example.domain.model.user.DomainUserInfoResponse
import com.example.domain.repository.user.userinfo.UserInfoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserInfoUseCase(
    private val repository: UserInfoRepository
) {
    operator fun invoke(
        id: Int?,
        scope: CoroutineScope,
        onResult: (DomainUserInfoResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getUserInfo(id)
            }
            onResult(deferred.await())
        }
    }
}
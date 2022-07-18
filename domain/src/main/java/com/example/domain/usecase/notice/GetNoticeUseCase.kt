package com.example.domain.usecase.notice

import com.example.domain.model.notice.DomainBaseNoticeResponse
import com.example.domain.repository.notice.GetNoticeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetNoticeUseCase @Inject constructor(
    private val repository: GetNoticeRepository
) {
    operator fun invoke(
        notice: Int,
        scope: CoroutineScope,
        onResult: (DomainBaseNoticeResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getNotice(notice)
            }
            onResult(deferred.await())
        }
    }
}
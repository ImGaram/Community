package com.example.domain.usecase.notice

import com.example.domain.model.notice.DomainBaseNoticeResponse
import com.example.domain.repository.notice.NoticeListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoticeListUseCase @Inject constructor(
    private val repository: NoticeListRepository
) {
    operator fun invoke(
        scope: CoroutineScope,
        onResult: (List<DomainBaseNoticeResponse>?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getNoticeList()
            }
            onResult(deferred.await())
        }
    }
}
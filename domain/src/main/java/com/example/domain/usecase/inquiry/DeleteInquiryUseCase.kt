package com.example.domain.usecase.inquiry

import com.example.domain.repository.inquiry.DeleteInquiryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteInquiryUseCase @Inject constructor(
    private val repository: DeleteInquiryRepository
) {
    operator fun invoke(
        inquiry: Int,
        scope: CoroutineScope,
        onResult: (Int?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.deleteInquiry(inquiry)
            }
            onResult(deferred.await())
        }
    }
}
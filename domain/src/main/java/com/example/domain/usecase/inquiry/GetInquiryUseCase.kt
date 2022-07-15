package com.example.domain.usecase.inquiry

import com.example.domain.model.inquiry.DomainBaseInquiryResponse
import com.example.domain.repository.inquiry.GetInquiryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetInquiryUseCase @Inject constructor(
    private val repository: GetInquiryRepository
) {
    operator fun invoke(
        inquiry: Int,
        scope: CoroutineScope,
        onResult: (DomainBaseInquiryResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getInquiry(inquiry)
            }
            onResult(deferred.await())
        }
    }
}
package com.example.domain.usecase.inquiry

import com.example.domain.model.inquiry.DomainBaseInquiryResponse
import com.example.domain.repository.inquiry.GetInquiryListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetInquiryListUseCase @Inject constructor(
    private val repository: GetInquiryListRepository
) {
    operator fun invoke(
        scope: CoroutineScope,
        onResult: (List<DomainBaseInquiryResponse>?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getInquiryList()
            }
            onResult(deferred.await())
        }
    }
}
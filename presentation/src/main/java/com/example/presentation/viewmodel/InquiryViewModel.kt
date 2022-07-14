package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.inquiry.DomainBaseInquiryResponse
import com.example.domain.usecase.inquiry.CreateInquiryUseCase
import com.example.domain.usecase.inquiry.GetInquiryListUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InquiryViewModel @Inject constructor(
    private val createInquiryUseCase: CreateInquiryUseCase,
    private val getInquiryListUseCase: GetInquiryListUseCase
): BaseViewModel() {
    // create inquiry
    private val _createInquiry = MutableLiveData<DomainBaseInquiryResponse>()
    val createInquiry: LiveData<DomainBaseInquiryResponse> = _createInquiry
    fun createInquiryLogic(title: String, context: String, createUserId: Int) {
        viewModelScope.launch {
            createInquiryUseCase(title, context, createUserId, viewModelScope) {
                _createInquiry.value = it
            }
        }
    }

    // get inquiry list
    private val _getInquiryList = MutableLiveData<List<DomainBaseInquiryResponse>>()
    val getInquiryList: LiveData<List<DomainBaseInquiryResponse>> = _getInquiryList
    fun getInquiryListLogic() {
        viewModelScope.launch {
            getInquiryListUseCase(viewModelScope) {
                _getInquiryList.value = it
            }
        }
    }
}
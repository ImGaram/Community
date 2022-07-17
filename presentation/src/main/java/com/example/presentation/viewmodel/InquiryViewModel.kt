package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.inquiry.DomainBaseInquiryResponse
import com.example.domain.usecase.inquiry.*
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InquiryViewModel @Inject constructor(
    private val createInquiryUseCase: CreateInquiryUseCase,
    private val getInquiryListUseCase: GetInquiryListUseCase,
    private val getInquiryUseCase: GetInquiryUseCase,
    private val modifyInquiryUseCase: ModifyInquiryUseCase,
    private val deleteInquiryUseCase: DeleteInquiryUseCase
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

    // get inquiry
    private val _getInquiry = MutableLiveData<DomainBaseInquiryResponse>()
    val getInquiry: LiveData<DomainBaseInquiryResponse> = _getInquiry
    fun getInquiryLogic(inquiry: Int) {
        viewModelScope.launch {
            getInquiryUseCase(inquiry, viewModelScope) {
                _getInquiry.value = it
            }
        }
    }

    // modify inquiry
    private val _modifyInquiry = MutableLiveData<DomainBaseInquiryResponse>()
    val modifyInquiry: LiveData<DomainBaseInquiryResponse> = _modifyInquiry
    fun modifyInquiryLogic(inquiry: Int, title: String, context: String, createUserId: Int) {
        viewModelScope.launch {
            modifyInquiryUseCase(inquiry, title, context, createUserId, viewModelScope) {
                _modifyInquiry.value = it
            }
        }
    }

    // delete inquiry
    private val _deleteInquiry = MutableLiveData<Int>()
    val deleteInquiry: LiveData<Int> = _deleteInquiry
    fun deleteInquiryLogic(inquiry: Int) {
        viewModelScope.launch {
            deleteInquiryUseCase(inquiry, viewModelScope) {
                _deleteInquiry.value = it
            }
        }
    }
}
package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.notice.DomainBaseNoticeResponse
import com.example.domain.usecase.notice.NoticeListUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoticeViewModel @Inject constructor(
    private val noticeListUseCase: NoticeListUseCase
): BaseViewModel() {
    // get notice list
    private val _getNoticeList = MutableLiveData<List<DomainBaseNoticeResponse>>()
    val getNoticeList: LiveData<List<DomainBaseNoticeResponse>> = _getNoticeList
    fun getNoticeListLogic() {
        viewModelScope.launch {
            noticeListUseCase(viewModelScope) {
                _getNoticeList.value = it
            }
        }
    }
}
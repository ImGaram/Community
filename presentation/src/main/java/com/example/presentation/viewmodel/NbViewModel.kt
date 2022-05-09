package com.example.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainSignInResponse
import com.example.domain.usecase.SignInUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NbViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
): BaseViewModel() {

    private val _apiCallResult = MutableLiveData<DomainSignInResponse>()
    val apiCallResult: LiveData<DomainSignInResponse> = _apiCallResult
    fun signInLogic(name: String, email: String, password: String) {
        viewModelScope.launch{
            // TODO :: response json data 받기
            signInUseCase(name, email, password, viewModelScope) {
                _apiCallResult.value = it
                Log.d("SUCCESS", "_apiCallResult.value: ${_apiCallResult.value}")
            }
        }
    }
}
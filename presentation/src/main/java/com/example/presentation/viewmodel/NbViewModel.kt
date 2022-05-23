package com.example.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.user.DomainLoginResponse
import com.example.domain.model.user.DomainSignInResponse
import com.example.domain.model.user.DomainUserInfoResponse
import com.example.domain.usecase.login.LoginUseCase
import com.example.domain.usecase.signin.SignInUseCase
import com.example.domain.usecase.userinfo.UserInfoUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NbViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val loginUseCase: LoginUseCase,
    private val userInfoUseCase: UserInfoUseCase
): BaseViewModel() {
    // 회원가입
    private val _signInApiCallResult = MutableLiveData<DomainSignInResponse>()
    val signInApiCallResult: LiveData<DomainSignInResponse> = _signInApiCallResult
    fun signInLogic(name: String, email: String, password: String) {
        viewModelScope.launch{
            signInUseCase(name, email, password, viewModelScope) {
                _signInApiCallResult.value = it
                Log.d("SUCCESS", "_signInApiCallResult.value: ${_signInApiCallResult.value}")
            }
        }
    }

    // 로그인
    private val _loginApiCallResult = MutableLiveData<DomainLoginResponse>()
    val loginApiCallResult: LiveData<DomainLoginResponse> = _loginApiCallResult
    fun loginLogic(email: String, password: String) {
        viewModelScope.launch {
            loginUseCase(email, password, viewModelScope) {
                _loginApiCallResult.value = it
                Log.d("SUCCESS", "_loginApiCallResult.value: ${_loginApiCallResult.value}")
            }
        }
    }

    // 유저 정보
    private val _userInfoApiCallResult = MutableLiveData<DomainUserInfoResponse>()
    val userInfoApiCallResult: LiveData<DomainUserInfoResponse> = _userInfoApiCallResult
    fun getUserLogic(id: Int) {
        viewModelScope.launch {
            userInfoUseCase(id, viewModelScope) {
                _userInfoApiCallResult.value = it
                Log.d("SUCCESS", "_userInfoApiCallResult.value: ${_userInfoApiCallResult.value}")
            }
        }
    }
}
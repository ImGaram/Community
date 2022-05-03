package com.example.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainSignInResponse
import com.example.domain.usecase.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NbViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
): ViewModel() {

    var apiCallResult = DomainSignInResponse("","","","")
    fun signInLogic(name: String, email: String, password: String) {
        viewModelScope.launch {
            signInUseCase.buildUseCaseObservable(name, email, password).let { response ->
                if (response != null) {
                    // TODO :: response json data 받기
                    apiCallResult = response
                    Log.d("SUCCESS", "signInLogic: $apiCallResult")
                    Log.d("SUCCESS", "signInLogic json: $response")
                } else {
                    Log.d("FAIL", "signInLogic Fail")
                }
            }
        }
    }
}
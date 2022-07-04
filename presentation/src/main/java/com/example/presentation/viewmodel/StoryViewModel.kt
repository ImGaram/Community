package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.domain.usecase.story.CreateStoryUseCase
import com.example.domain.usecase.story.GetStoryUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor(
    private val createStoryUseCase: CreateStoryUseCase,
    private val getStoryUseCase: GetStoryUseCase
): BaseViewModel() {
    // create story
    private val _createStory = MutableLiveData<DomainBaseStoryResponse>()
    val createStory: LiveData<DomainBaseStoryResponse> = _createStory
    fun createStoryLogic(
        title: String,
        context: String,
        createUser: Int
    ) {
        viewModelScope.launch {
            createStoryUseCase(title, context, createUser, viewModelScope) {
                _createStory.value = it
            }
        }
    }

    // get story
    private val _getStory = MutableLiveData<List<DomainBaseStoryResponse>>()
    val getStory: LiveData<List<DomainBaseStoryResponse>> = _getStory
    fun getStoryLogic() {
        viewModelScope.launch {
            getStoryUseCase(viewModelScope) {
                _getStory.value = it
            }
        }
    }
}
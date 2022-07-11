package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.domain.usecase.story.CreateStoryUseCase
import com.example.domain.usecase.story.GetSingleStoryUseCase
import com.example.domain.usecase.story.GetStoryUseCase
import com.example.domain.usecase.story.ModifyStoryUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor(
    private val createStoryUseCase: CreateStoryUseCase,
    private val getStoryUseCase: GetStoryUseCase,
    private val getSingleStoryUseCase: GetSingleStoryUseCase,
    private val modifyStoryUseCase: ModifyStoryUseCase
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

    // get single story
    private val _getSingleStory = MutableLiveData<DomainBaseStoryResponse>()
    val getSingleStory: LiveData<DomainBaseStoryResponse> = _getSingleStory
    fun getSingleStoryLogic(storyId: Int) {
        viewModelScope.launch {
            getSingleStoryUseCase(storyId, viewModelScope) {
                _getSingleStory.value = it
            }
        }
    }

    // modify story
    private val _modifyStory = MutableLiveData<DomainBaseStoryResponse>()
    val modifyStory: LiveData<DomainBaseStoryResponse> = _modifyStory
    fun modifyStoryLogic(story: Int, title: String, content: String, createUser: Int) {
        viewModelScope.launch {
            modifyStoryUseCase(story, title, content, createUser, viewModelScope) {
                _modifyStory.value = it
            }
        }
    }
}
package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.domain.model.story.DomainBaseCommentResponse
import com.example.domain.usecase.story.*
import com.example.domain.usecase.story.comment.CreateCommentUseCase
import com.example.domain.usecase.story.comment.GetCommentListUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor(
    private val createStoryUseCase: CreateStoryUseCase,
    private val getStoryUseCase: GetStoryUseCase,
    private val getSingleStoryUseCase: GetSingleStoryUseCase,
    private val modifyStoryUseCase: ModifyStoryUseCase,
    private val deleteStoryUseCase: DeleteStoryUseCase,
    private val createCommentUseCase: CreateCommentUseCase,
    private val getCommentListUseCase: GetCommentListUseCase
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

    // delete story
    private val _deleteStory = MutableLiveData<Int>()
    val deleteStory: LiveData<Int> = _deleteStory
    fun deleteStoryLogic(story: Int) {
        viewModelScope.launch {
            deleteStoryUseCase(story, viewModelScope) {
                _deleteStory.value = it
            }
        }
    }

    // create comment
    private val _createComment = MutableLiveData<DomainBaseCommentResponse>()
    val createComment: LiveData<DomainBaseCommentResponse> = _createComment
    fun createCommentLogic(context: String, createIdUserSt: Int, commentStory: Int) {
        viewModelScope.launch {
            createCommentUseCase(context, createIdUserSt, commentStory, viewModelScope) {
                _createComment.value = it
            }
        }
    }

    // get comment list
    private val _getCommentList = MutableLiveData<List<DomainBaseCommentResponse>>()
    val getCommentList: LiveData<List<DomainBaseCommentResponse>> = _getCommentList
    fun getCommentListLogic(story: Int) {
        viewModelScope.launch {
            getCommentListUseCase(story, viewModelScope) {
                _getCommentList.value = it
            }
        }
    }
}
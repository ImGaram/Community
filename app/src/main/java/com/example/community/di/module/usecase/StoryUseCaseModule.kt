package com.example.community.di.module.usecase

import com.example.domain.repository.story.*
import com.example.domain.repository.story.comment.CreateCommentRepository
import com.example.domain.repository.story.comment.GetCommentListRepository
import com.example.domain.repository.story.comment.GetSuggestRepository
import com.example.domain.repository.story.comment.SuggestStoryRepository
import com.example.domain.usecase.story.*
import com.example.domain.usecase.story.comment.CreateCommentUseCase
import com.example.domain.usecase.story.comment.GetCommentListUseCase
import com.example.domain.usecase.story.comment.GetSuggestUseCase
import com.example.domain.usecase.story.comment.SuggestStoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StoryUseCaseModule {
    @Provides
    @Singleton
    fun provideCreateStoryUseCase(repository: CreateStoryRepository) = CreateStoryUseCase(repository)

    @Provides
    @Singleton
    fun provideGetStoryUseCase(repository: GetStoryRepository) = GetStoryUseCase(repository)

    @Provides
    @Singleton
    fun provideGetSingleStoryUseCase(repository: GetStorySingleRepository) = GetSingleStoryUseCase(repository)

    @Provides
    @Singleton
    fun provideModifyStoryUseCase(repository: ModifyStoryRepository) = ModifyStoryUseCase(repository)

    @Provides
    @Singleton
    fun provideDeleteStoryUseCase(repository: DeleteStoryRepository) = DeleteStoryUseCase(repository)

    @Provides
    @Singleton
    fun provideCreateCommentUseCase(repository: CreateCommentRepository) = CreateCommentUseCase(repository)

    @Provides
    @Singleton
    fun provideGetCommentListUseCase(repository: GetCommentListRepository) = GetCommentListUseCase(repository)

    @Provides
    @Singleton
    fun provideSuggestStoryUseCase(repository: SuggestStoryRepository) = SuggestStoryUseCase(repository)

    @Provides
    @Singleton
    fun provideGetSuggestUseCase(repository: GetSuggestRepository) = GetSuggestUseCase(repository)
}
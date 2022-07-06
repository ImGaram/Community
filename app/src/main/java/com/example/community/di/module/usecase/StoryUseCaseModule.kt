package com.example.community.di.module.usecase

import com.example.domain.repository.story.CreateStoryRepository
import com.example.domain.repository.story.GetStoryRepository
import com.example.domain.repository.story.GetStorySingleRepository
import com.example.domain.usecase.story.CreateStoryUseCase
import com.example.domain.usecase.story.GetSingleStoryUseCase
import com.example.domain.usecase.story.GetStoryUseCase
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
}
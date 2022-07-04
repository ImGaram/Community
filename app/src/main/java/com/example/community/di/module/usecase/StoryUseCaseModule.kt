package com.example.community.di.module.usecase

import com.example.domain.repository.story.CreateStoryRepository
import com.example.domain.usecase.story.CreateStoryUseCase
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
}
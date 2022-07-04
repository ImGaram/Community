package com.example.community.di.module.repository

import com.example.data.datasource.story.datasource.CreateStoryDataSourceImpl
import com.example.data.datasource.story.repository.CreateStoryRepositoryImpl
import com.example.domain.repository.story.CreateStoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StoryRepositoryModule {
    @Provides
    @Singleton
    fun provideCreateStoryRepository(dataSourceImpl: CreateStoryDataSourceImpl): CreateStoryRepository {
        return CreateStoryRepositoryImpl(dataSourceImpl)
    }
}
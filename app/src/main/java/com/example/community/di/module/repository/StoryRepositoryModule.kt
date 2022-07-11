package com.example.community.di.module.repository

import com.example.data.datasource.story.datasource.CreateStoryDataSourceImpl
import com.example.data.datasource.story.datasource.GetStoryDataSourceImpl
import com.example.data.datasource.story.datasource.GetStorySingleDataSourceImpl
import com.example.data.datasource.story.datasource.ModifyStoryDataSourceImpl
import com.example.data.datasource.story.repository.CreateStoryRepositoryImpl
import com.example.data.datasource.story.repository.GetSingleStoryRepositoryImpl
import com.example.data.datasource.story.repository.GetStoryRepositoryImpl
import com.example.data.datasource.story.repository.ModifyStoryRepositoryImpl
import com.example.domain.repository.story.CreateStoryRepository
import com.example.domain.repository.story.GetStoryRepository
import com.example.domain.repository.story.GetStorySingleRepository
import com.example.domain.repository.story.ModifyStoryRepository
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

    @Provides
    @Singleton
    fun provideGetStoryRepository(dataSourceImpl: GetStoryDataSourceImpl): GetStoryRepository {
        return GetStoryRepositoryImpl(dataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideGetSingleStoryRepository(dataSourceImpl: GetStorySingleDataSourceImpl): GetStorySingleRepository {
        return GetSingleStoryRepositoryImpl(dataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideModifyStoryRepository(dataSourceImpl: ModifyStoryDataSourceImpl): ModifyStoryRepository {
        return ModifyStoryRepositoryImpl(dataSourceImpl)
    }
}
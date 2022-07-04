package com.example.community.di.module.data

import com.example.data.api.story.CreateStoryService
import com.example.data.api.story.GetStoryService
import com.example.data.datasource.story.datasource.CreateStoryDataSourceImpl
import com.example.data.datasource.story.datasource.GetStoryDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StoryDataSourceModule {
    @Provides
    @Singleton
    fun provideCreateStoryDataSource(service: CreateStoryService): CreateStoryDataSourceImpl {
        return CreateStoryDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideGetStoryDataSource(service: GetStoryService): GetStoryDataSourceImpl {
        return GetStoryDataSourceImpl(service)
    }
}
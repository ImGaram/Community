package com.example.community.di.module.repository

import com.example.data.datasource.story.datasource.*
import com.example.data.datasource.story.datasource.comment.CreateCommentDataSourceImpl
import com.example.data.datasource.story.repository.*
import com.example.data.datasource.story.repository.comment.CreateCommentRepositoryImpl
import com.example.domain.repository.story.*
import com.example.domain.repository.story.comment.CreateCommentRepository
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

    @Provides
    @Singleton
    fun provideDeleteStoryRepository(dataSourceImpl: DeleteStoryDataSourceImpl): DeleteStoryRepository {
        return DeleteStoryRepositoryImpl(dataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideCreateCommentRepository(dataSourceImpl: CreateCommentDataSourceImpl): CreateCommentRepository {
        return CreateCommentRepositoryImpl(dataSourceImpl)
    }
}
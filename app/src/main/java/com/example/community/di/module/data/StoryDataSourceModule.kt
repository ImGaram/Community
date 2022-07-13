package com.example.community.di.module.data

import com.example.data.api.story.*
import com.example.data.api.story.comment.CreateStoryCommentService
import com.example.data.api.story.comment.GetCommentListService
import com.example.data.api.story.comment.GetSuggestService
import com.example.data.api.story.comment.SuggestStoryService
import com.example.data.datasource.story.datasource.*
import com.example.data.datasource.story.datasource.comment.CreateCommentDataSourceImpl
import com.example.data.datasource.story.datasource.comment.GetCommentListDataSourceImpl
import com.example.data.datasource.story.datasource.comment.GetSuggestDataSourceImpl
import com.example.data.datasource.story.datasource.comment.SuggestStoryDataSourceImpl
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

    @Provides
    @Singleton
    fun provideGetSingleStoryDataSource(service: GetStorySingleService): GetStorySingleDataSourceImpl {
        return GetStorySingleDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideModifyStoryDataSource(service: ModifyStoryService): ModifyStoryDataSourceImpl {
        return ModifyStoryDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideDeleteStoryDataSource(service: DeleteStoryService): DeleteStoryDataSourceImpl {
        return DeleteStoryDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideCreateCommentDataSource(service: CreateStoryCommentService): CreateCommentDataSourceImpl {
        return CreateCommentDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideGetCommentListDataSource(service: GetCommentListService): GetCommentListDataSourceImpl {
        return GetCommentListDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideSuggestStoryDataSource(service: SuggestStoryService): SuggestStoryDataSourceImpl {
        return SuggestStoryDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideGetSuggestDataSource(service: GetSuggestService): GetSuggestDataSourceImpl {
        return GetSuggestDataSourceImpl(service)
    }
}
package com.example.community.di.module.usecase

import com.example.domain.repository.notice.NoticeListRepository
import com.example.domain.usecase.notice.NoticeListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NoticeUseCaseModule {
    @Provides
    @Singleton
    fun provideNoticeListUseCase(repository: NoticeListRepository) = NoticeListUseCase(repository)
}
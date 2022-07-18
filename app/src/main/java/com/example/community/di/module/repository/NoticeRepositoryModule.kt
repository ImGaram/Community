package com.example.community.di.module.repository

import com.example.data.datasource.notice.datasource.GetNoticeDataSourceImpl
import com.example.data.datasource.notice.datasource.NoticeListDataSourceImpl
import com.example.data.datasource.notice.repository.GetNoticeRepositoryImpl
import com.example.data.datasource.notice.repository.NoticeListRepositoryImpl
import com.example.domain.repository.notice.GetNoticeRepository
import com.example.domain.repository.notice.NoticeListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NoticeRepositoryModule {
    @Provides
    @Singleton
    fun provideNoticeListRepository(dataSourceImpl: NoticeListDataSourceImpl): NoticeListRepository {
        return NoticeListRepositoryImpl(dataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideGetNoticeRepository(dataSourceImpl: GetNoticeDataSourceImpl): GetNoticeRepository {
        return GetNoticeRepositoryImpl(dataSourceImpl)
    }
}
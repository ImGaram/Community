package com.example.community.di.module.data

import com.example.data.api.notice.GetNoticeService
import com.example.data.api.notice.NoticeListService
import com.example.data.datasource.notice.datasource.GetNoticeDataSourceImpl
import com.example.data.datasource.notice.datasource.NoticeListDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NoticeDataSourceModule {
    @Provides
    @Singleton
    fun provideNoticeListDataSource(service: NoticeListService): NoticeListDataSourceImpl {
        return NoticeListDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideGetNoticeDataSource(service: GetNoticeService): GetNoticeDataSourceImpl {
        return GetNoticeDataSourceImpl(service)
    }
}
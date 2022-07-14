package com.example.community.di.module.data

import com.example.data.api.inquiry.CreateInquiryService
import com.example.data.datasource.inquiry.remote.CreateInquiryDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InquiryDataSourceModule {
    @Provides
    @Singleton
    fun provideCreateInquiryDataSource(service: CreateInquiryService): CreateInquiryDataSourceImpl {
        return CreateInquiryDataSourceImpl(service)
    }
}
package com.example.community.di.module.repository

import com.example.data.datasource.inquiry.remote.CreateInquiryDataSourceImpl
import com.example.data.datasource.inquiry.repositoryimpl.CreateInquiryRepositoryImpl
import com.example.domain.repository.inquiry.CreateInquiryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InquiryRepositoryModule {
    @Provides
    @Singleton
    fun provideCreateInquiryRepository(dataSourceImpl: CreateInquiryDataSourceImpl): CreateInquiryRepository {
        return CreateInquiryRepositoryImpl(dataSourceImpl)
    }
}
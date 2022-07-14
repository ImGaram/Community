package com.example.community.di.module.usecase

import com.example.domain.repository.inquiry.CreateInquiryRepository
import com.example.domain.repository.inquiry.GetInquiryListRepository
import com.example.domain.usecase.inquiry.CreateInquiryUseCase
import com.example.domain.usecase.inquiry.GetInquiryListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InquiryUseCaseModule {
    @Provides
    @Singleton
    fun provideCreateInquiryUseCase(repository: CreateInquiryRepository) = CreateInquiryUseCase(repository)

    @Provides
    @Singleton
    fun provideGetInquiryUseCase(repository: GetInquiryListRepository) = GetInquiryListUseCase(repository)
}
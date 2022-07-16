package com.example.community.di.module.usecase

import com.example.domain.repository.inquiry.CreateInquiryRepository
import com.example.domain.repository.inquiry.GetInquiryListRepository
import com.example.domain.repository.inquiry.GetInquiryRepository
import com.example.domain.repository.inquiry.ModifyInquiryRepository
import com.example.domain.usecase.inquiry.CreateInquiryUseCase
import com.example.domain.usecase.inquiry.GetInquiryListUseCase
import com.example.domain.usecase.inquiry.GetInquiryUseCase
import com.example.domain.usecase.inquiry.ModifyInquiryUseCase
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
    fun provideGetInquiryListUseCase(repository: GetInquiryListRepository) = GetInquiryListUseCase(repository)

    @Provides
    @Singleton
    fun provideGetInquiryUseCase(repository: GetInquiryRepository) = GetInquiryUseCase(repository)

    @Provides
    @Singleton
    fun provideModifyInquiryUseCase(repository: ModifyInquiryRepository) = ModifyInquiryUseCase(repository)
}
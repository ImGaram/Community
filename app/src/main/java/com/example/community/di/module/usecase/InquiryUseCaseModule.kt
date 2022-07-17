package com.example.community.di.module.usecase

import com.example.domain.repository.inquiry.*
import com.example.domain.usecase.inquiry.*
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

    @Provides
    @Singleton
    fun provideDeleteInquiryUseCase(repository: DeleteInquiryRepository) = DeleteInquiryUseCase(repository)
}
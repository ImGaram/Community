package com.example.domain

abstract class ParamsUseCase<in Params, out T> {
    abstract suspend fun buildUseCaseObservable(params: Params): T
}
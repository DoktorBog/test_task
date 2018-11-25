package com.test.presentation.di

import com.test.data.repository.RouteRepositoryImpl
import com.test.domain.repository.RoutesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRoutesRepository(repository: RouteRepositoryImpl): RoutesRepository


}
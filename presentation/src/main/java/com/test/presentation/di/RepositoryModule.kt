package com.test.presentation.di

import com.test.data.repository.SmartBoxRepositoryImpl
import com.test.domain.repository.SmartBoxRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRoutesRepository(repository: SmartBoxRepositoryImpl): SmartBoxRepository


}
package com.test.presentation.di

import android.arch.lifecycle.ViewModelProvider
import com.test.presentation.base.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}

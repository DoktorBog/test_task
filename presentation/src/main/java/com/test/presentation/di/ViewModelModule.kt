package com.test.presentation.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.test.presentation.base.ViewModelFactory
import com.test.presentation.base.ViewModelKey
import com.test.presentation.main.DataViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Singleton
    @Binds
    @IntoMap
    @ViewModelKey(DataViewModel::class)
    internal abstract fun postDataViewModel(viewModel: DataViewModel): ViewModel

}

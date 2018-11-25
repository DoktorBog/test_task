package com.test.presentation.di

import com.test.presentation.App
import com.test.presentation.main.MainActivity
import com.test.presentation.main.PageFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, NetworkModule::class, RepositoryModule::class])
interface Injector {

    fun inject(app: App)

    fun inject(activity: MainActivity)

    fun inject(fragment: PageFragment)

}
package com.test.presentation.di

import android.content.ContentResolver
import android.content.Context
import android.content.SharedPreferences
import com.test.presentation.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp(): App = app

    @Provides
    @Singleton
    fun provideAppContext(): Context = app

    @Provides
    fun provideContentResolver(): ContentResolver = app.contentResolver

    @Provides
    @Singleton
    fun provideSharedPreferences(app: App) : SharedPreferences = app.getSharedPreferences(app.packageName, Context.MODE_PRIVATE)

}
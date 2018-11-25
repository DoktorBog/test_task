package com.test.presentation

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import android.support.v7.app.AppCompatDelegate
import com.pacoworks.rxpaper2.RxPaperBook
import com.test.presentation.di.AppModule
import com.test.presentation.di.DaggerInjector
import com.test.presentation.di.Injector
import com.test.presentation.di.NetworkModule

class App : Application() {

    lateinit var injector: Injector private set

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        initDagger()
        initRxPaper()
    }

    private fun initDagger() {
        injector = DaggerInjector.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(this))
                .build()
        injector.inject(this)
    }


    private fun initRxPaper() = RxPaperBook.init(this)

}

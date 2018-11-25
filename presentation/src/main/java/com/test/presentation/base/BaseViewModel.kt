package com.test.presentation.base

import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    protected fun useDisposable(disposableCreator: () -> Disposable) {
        compositeDisposable.add(disposableCreator())
    }

    @CallSuper
    override fun onCleared() {
        compositeDisposable.clear()

        super.onCleared()
    }
}
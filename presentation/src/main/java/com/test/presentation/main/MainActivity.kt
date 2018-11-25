package com.test.presentation.main

import android.os.Bundle
import com.test.presentation.R
import com.test.presentation.base.BaseActivity
import com.test.presentation.extensions.getAppInjector

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun inject() {
        getAppInjector().inject(this)
    }

    override fun initViewModel() {}
}

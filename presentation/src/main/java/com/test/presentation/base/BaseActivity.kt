package com.test.presentation.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StyleRes
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

abstract class BaseActivity(@LayoutRes val layout : Int, @StyleRes val style : Int = 0) : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(style!=0) setTheme(style)
        setContentView(layout)
        inject()
        initViewModel()
        initView(savedInstanceState)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun inject()

    abstract fun initViewModel()


}
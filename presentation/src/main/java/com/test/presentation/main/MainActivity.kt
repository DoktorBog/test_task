package com.test.presentation.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.Toolbar
import com.test.presentation.R
import com.test.presentation.base.BaseActivity
import com.test.presentation.extensions.getAppInjector
import com.test.presentation.extensions.requireSupportActionBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun initView(savedInstanceState: Bundle?) {
        setSupportActionBar(toolbar as Toolbar)
        setupActionBar()
        setupPagerAdapter()
    }

    override fun inject() {
        getAppInjector().inject(this)
    }

    override fun initViewModel() {}

    private fun setupActionBar() = with(requireSupportActionBar()) {
        setTitle(R.string.app_name)
    }

    private fun setupPagerAdapter() = with(supportFragmentManager){
        viewPager.adapter = PagerAdapter(supportFragmentManager, this@MainActivity)
        tabLayout.setupWithViewPager(viewPager)
    }

    class PagerAdapter(fragmentManager: FragmentManager, private val context: Context) : FragmentPagerAdapter(fragmentManager) {

        override fun getItem(position: Int): Fragment =  PageFragment.newInstance(PageFragment.Type.values()[position])

        override fun getCount(): Int = 2

        override fun getPageTitle(position: Int): CharSequence {
            return when (position) {
                0 -> context.getString(R.string.events)
                1 -> context.getString(R.string.shops)
                else ->  "unchecked"
            }
        }
    }
}

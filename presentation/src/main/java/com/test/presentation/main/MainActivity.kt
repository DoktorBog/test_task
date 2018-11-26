package com.test.presentation.main

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.Toolbar
import com.test.presentation.R
import com.test.presentation.base.BaseActivity
import com.test.presentation.extensions.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(R.layout.activity_main) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel : DataViewModel
    private val progressDialog by lazyProgressDialog()

    override fun initView(savedInstanceState: Bundle?) {
        setSupportActionBar(toolbar as Toolbar)
        setupActionBar()
        setupPagerAdapter()
    }

    override fun inject() {
        getAppInjector().inject(this)
    }

    override fun initViewModel() {
        withViewModel<DataViewModel>(viewModelFactory) {
            viewModel = this
            observeNonNull(errors) { snackbar(it.message!!, duration = 10000) }
            observeNonNull(loadingState, progressDialog::setVisible)
            observeNonNull(routingEvents, this@MainActivity::onRoutingEvent)
            getData()
        }
    }

    private fun setupActionBar() = with(requireSupportActionBar()) {
        setTitle(R.string.app_name)
    }

    private fun setupPagerAdapter() = with(supportFragmentManager){
        viewPager.adapter = PagerAdapter(supportFragmentManager, this@MainActivity)
        tabLayout.setupWithViewPager(viewPager)
    }


    private fun onRoutingEvent(event: DataViewModel.RoutingEvent) {
        when (event) {
            is DataViewModel.RoutingEvent.RouteToDetailsScreen -> {

            }
        }
    }

    class PagerAdapter(fragmentManager: FragmentManager, context: Context) : FragmentPagerAdapter(fragmentManager) {

        val pages : List<PageFragment> get() = _pages

        private val _pages = ArrayList<PageFragment>()

        init {
            _pages.add(PageFragment.newInstance(PageFragment.Type.values()[0]))
            _pages.add(PageFragment.newInstance(PageFragment.Type.values()[1]))
            _pages[0].title = context.getString(R.string.events)
            _pages[1].title = context.getString(R.string.shops)
        }

        override fun getItem(position: Int): Fragment = _pages[position]

        override fun getCount(): Int = _pages.size

        override fun getPageTitle(position: Int): CharSequence = _pages[position].title
    }
}

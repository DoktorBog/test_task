package com.test.presentation.main

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.presentation.R
import com.test.presentation.extensions.getAppInjector
import com.test.presentation.extensions.observeNonNull
import com.test.presentation.extensions.withViewModel
import org.jetbrains.anko.bundleOf
import javax.inject.Inject

class PageFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel : DataViewModel

    var title: String = javaClass.name

    enum class Type { EVENT, SHOP }
    private val type by lazy { initType() }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        getAppInjector().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        withViewModel<DataViewModel>(viewModelFactory) {
            viewModel = this
            observeNonNull(data, ::updateView)
        }
    }

    private fun updateView(data: List<Data>) {
        initData(data.filter { it.type == type })
    }

    private fun setupClickListeners() {

    }

    private fun initType(): Type = arguments?.getSerializable("type") as Type


    fun initData(data: List<Data>){

    }

    companion object {
        fun newInstance(type: Type) = PageFragment().apply {
            arguments = bundleOf("type" to type)
        }
    }
}

package com.test.presentation.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.presentation.R
import com.test.presentation.extensions.getAppInjector
import org.jetbrains.anko.bundleOf

class PageFragment : Fragment() {

    enum class Type { EVENTS, SHOPS }
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
    }

    private fun setupClickListeners() {

    }

    private fun initType(): Type = arguments?.getSerializable("type") as Type


    private fun initData(){

    }

    companion object {
        fun newInstance(type: Type) = PageFragment().apply {
            arguments = bundleOf("type" to type)
        }
    }
}

package com.example.news.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(@LayoutRes id: Int) :
    Fragment(id) {

    protected abstract val binding: VB
    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRequest()
        setupSubscribes()
        initialize()
        setupListener()
    }

    protected open fun setupRequest() {}

    protected open fun setupSubscribes() {}

    protected open fun initialize() {}

    protected open fun setupListener() {}
}

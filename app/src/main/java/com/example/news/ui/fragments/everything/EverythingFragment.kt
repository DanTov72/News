package com.example.news.ui.fragments.everything

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.news.R
import com.example.news.base.BaseFragment
import com.example.news.common.Resource
import com.example.news.databinding.FragmentEverythingBinding
import com.example.news.ui.adapters.EverythingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<FragmentEverythingBinding, EverythingViewModel>(R.layout.fragment_everything) {
    override val binding by viewBinding(FragmentEverythingBinding::bind)
    override val viewModel: EverythingViewModel by viewModels()
    private val adapter = EverythingAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribes() {
        subscribesEverything()
    }


    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
    }

    private fun subscribesEverything() {
        viewModel.fetchEverything().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("btc", it.message.toString())
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    adapter.submitList(it.data!!.articles)
                }
            }
        }
    }
}
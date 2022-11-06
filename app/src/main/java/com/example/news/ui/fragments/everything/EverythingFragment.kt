package com.example.news.ui.fragments.everything

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.news.base.BaseFragment
import com.example.news.common.Resource
import com.example.news.ui.adapters.EverythingAdapter
import com.example.news20.R
import com.example.news20.databinding.FragmentEverythingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<FragmentEverythingBinding, EverythingViewModel>(R.layout.fragment_everything) {
    override val binding by viewBinding(FragmentEverythingBinding::bind)
    override val viewModel: EverythingViewModel by viewModels()
    private val adapter = EverythingAdapter()

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
    }

    override fun setupSubscribes() {
        subscribesEverything()
    }

    override fun initialize() {
        setupRecyclerView()
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
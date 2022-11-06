package com.example.news.ui.fragments.sources

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.news.base.BaseFragment
import com.example.news.common.Resource
import com.example.news.ui.adapters.SourcesAdapter
import com.example.news20.R
import com.example.news20.databinding.FragmentSourcesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourcesFragment : BaseFragment<FragmentSourcesBinding, SourcesViewModel>(R.layout.fragment_sources) {

    override val binding by viewBinding(FragmentSourcesBinding::bind)
    override val viewModel: SourcesViewModel by viewModels()
    private val adapter = SourcesAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribes() {
        subscribesSources()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
    }

    private fun subscribesSources() {
        viewModel.fetchSources().observe(viewLifecycleOwner) {
            when (it){
                is Resource.Error -> {
                    Log.e("sources", it.message.toString() )}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    adapter.submitList(it.data?.articles)
                }
            }
        }
    }
}
package com.example.news.ui.fragments.toparticles

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.news.R
import com.example.news.base.BaseFragment
import com.example.news.common.Resource
import com.example.news.databinding.FragmentTopArticlesBinding
import com.example.news.ui.adapters.TopArticlesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopArticlesFragment :
    BaseFragment<FragmentTopArticlesBinding, TopArticlesViewModel>(R.layout.fragment_top_articles) {

    override val binding by viewBinding(FragmentTopArticlesBinding::bind)
    override val viewModel: TopArticlesViewModel by viewModels()
    private val adapter = TopArticlesAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribes() {
        subscribesTopArticles()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
    }

    private fun subscribesTopArticles() {
        viewModel.fetchTopArticles().observe(viewLifecycleOwner) {
            when(it) {
                is Resource.Error -> {
                    Log.e("top", it.message.toString() )}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    adapter.submitList(it.data?.articles)
                }
            }
        }
    }
}
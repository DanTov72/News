package com.example.news.ui.fragments.toparticles

import com.example.news.base.BaseViewModel
import com.example.news.data.repositories.EverythingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopArticlesViewModel @Inject constructor(private val repository: EverythingRepository) :
    BaseViewModel() {

    fun fetchTopArticles() = repository.fetchTopArticles()

}
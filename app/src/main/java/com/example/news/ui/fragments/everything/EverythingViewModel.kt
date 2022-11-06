package com.example.news.ui.fragments.everything

import com.example.news.base.BaseRepository
import com.example.news.base.BaseViewModel
import com.example.news.data.repositories.EverythingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EverythingViewModel @Inject constructor(private val repository: EverythingRepository) :
    BaseViewModel() {

    fun fetchEverything() = repository.fetchEverything()
}
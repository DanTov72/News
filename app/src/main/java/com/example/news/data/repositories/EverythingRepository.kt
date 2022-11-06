package com.example.news.data.repositories

import com.example.news.base.BaseRepository
import com.example.news.data.remote.apiservices.NewsApiServices
import javax.inject.Inject

class EverythingRepository @Inject constructor(private val service: NewsApiServices) :
    BaseRepository() {

    fun fetchEverything() = doRequest {
        service.fetchEverything("bitcoin")
    }

    fun fetchTopArticles() = doRequest {
        service.fetchTopArticles("us")
    }

    fun fetchSources() = doRequest {
        service.fetchSources()
    }
}
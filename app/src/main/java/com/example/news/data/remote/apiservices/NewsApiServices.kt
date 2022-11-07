package com.example.news.data.remote.apiservices

import com.example.news.models.everything.EverythingNewsItem
import com.example.news.models.NewsResponse
import com.example.news.models.sources.SourcesNewItem
import com.example.news.models.toparticles.TopArticlesNewsItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsApiServices {

    @GET("top-headlines")
    suspend fun fetchTopArticles(
        @Query("country") country: String
    ): Response<NewsResponse<TopArticlesNewsItem>>

    @GET("everything")
    suspend fun fetchEverything(
        @Query("q") query: String,
    ): Response<NewsResponse<EverythingNewsItem>>

    @GET("top-headlines/sources")
    suspend fun fetchSources(
        @Header("apiKey") k: String = "API_KEY"
    ): Response<NewsResponse<SourcesNewItem>>
}
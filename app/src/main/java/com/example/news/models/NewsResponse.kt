package com.example.news.models

import com.example.news.models.everything.EverythingNewsItem
import com.google.gson.annotations.SerializedName

data class NewsResponse<T>(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResult")
    val totalResult: Int,
    @SerializedName("articles")
    val articles: List<T>
)
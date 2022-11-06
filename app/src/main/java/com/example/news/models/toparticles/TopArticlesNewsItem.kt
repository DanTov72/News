package com.example.news.models.toparticles

import com.example.news.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName
import java.net.URL

data class TopArticlesNewsItem(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("title")
    val tittle: String,
    @SerializedName("urlToImage")
    val image: String
) : IBaseDiffModel<Int>

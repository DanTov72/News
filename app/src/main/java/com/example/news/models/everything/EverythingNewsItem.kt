package com.example.news.models.everything

import com.example.news.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class EverythingNewsItem(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("title")
    val tittle: String
) : IBaseDiffModel<Int>

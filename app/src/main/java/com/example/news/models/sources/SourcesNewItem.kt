package com.example.news.models.sources

import com.example.news.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class SourcesNewItem(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("category")
    val category: String
) : IBaseDiffModel<Int>
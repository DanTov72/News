package com.example.news.models.sources

import com.example.news.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class SourcesNewItem(
    @SerializedName("description")
    val description: String,

    @SerializedName("language")
    val language: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("id")
    override val id: Int,

) : IBaseDiffModel<Int>
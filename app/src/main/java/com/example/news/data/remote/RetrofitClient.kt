package com.example.news.data.remote

import com.example.news.data.remote.apiservices.NewsApiServices
import com.example.news.data.remote.interceptors.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val retrofit =
        Retrofit.Builder().baseUrl("https://newsapi.org/v2/").client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create()).build()

    private fun provideOkHttpClient() = OkHttpClient()
        .newBuilder()
        .addInterceptor(ApiKeyInterceptor())
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor()
            .setLevel(
                HttpLoggingInterceptor
                    .Level.BODY
            )

    fun provideNewsApiService() = retrofit.create(NewsApiServices::class.java)
}
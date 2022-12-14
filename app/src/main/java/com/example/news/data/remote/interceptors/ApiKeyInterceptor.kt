package com.example.news.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url =
            request.url.newBuilder()
                .addQueryParameter("X-Api-Key", "43f407381b4a44c595c6a05ba09ae0f7").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
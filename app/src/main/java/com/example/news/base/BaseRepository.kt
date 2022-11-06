package com.example.news.base

import androidx.lifecycle.liveData
import com.example.news.common.Resource
import okio.IOException
import retrofit2.Response

abstract class BaseRepository {

    fun <T> doRequest(result: suspend () -> Response<T>) = liveData {
        emit(Resource.Loading())
        try {
            result().let {
                if (it.isSuccessful && it.body() != null) emit(Resource.Success(it.body()!!))
                else emit(Resource.Error(it.message(), null))
            }
        } catch (ioException: IOException) {
            emit(Resource.Error(ioException.localizedMessage.toString() ?: "error", data = null))
        }
    }
}
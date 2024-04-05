package com.example.rikeandmortykoin.ui.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.rikeandmortykoin.utils.Resource
import kotlinx.coroutines.Dispatchers

abstract class BaseRepository {
    fun <T> performNetworkRequest(apiCall: suspend () -> T): LiveData<Resource<T>> =
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                val response = apiCall()
                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "Unknown error!"))
                e.localizedMessage?.let { Log.e("ololo", it) }
            }
        }
}
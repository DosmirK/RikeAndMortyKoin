package com.example.rikeandmortykoin.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.rikeandmortykoin.utils.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

object BaseRepository {

    /*fun getRequestApi(suspendFunction: suspend () -> Unit) : LiveData<Resource<Character>> {
        // Запускаем переданную suspend функцию в корутине
        return liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                val response = suspendFunction
                if (response.isSuccessful && response.code() in 200..300 && response.body() != null) {
                    response.body()?.let {
                        emit(Resource.Success(it))
                    }
                }
            }catch (e: Exception){
                emit(Resource.Error(e.localizedMessage?: "Unknown error!"))
            }
        }
    }*/

    fun <T> performNetworkRequest(apiCall: suspend () -> Response<T>): LiveData<Resource<T>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.Loading())

            try {
                val response = apiCall()

                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(Resource.Success(it))
                    }
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "Unknown error!"))
                e.localizedMessage?.let { Log.e("ololo", it) }
            }
        }
    }
}
package com.example.rikeandmortykoin.repository

import androidx.lifecycle.LiveData
import com.example.rikeandmortykoin.data.CartoonApiService
import com.example.rikeandmortykoin.data.Character
import com.example.rikeandmortykoin.ui.base.BaseRepository
import com.example.rikeandmortykoin.utils.Resource

class CharactersRepository (
    private val api: CartoonApiService
): BaseRepository() {

    suspend fun getCharacter(): LiveData<Resource<List<Character>>> = performNetworkRequest {
        api.getCharacters().body()?.results ?: emptyList()
    }
}
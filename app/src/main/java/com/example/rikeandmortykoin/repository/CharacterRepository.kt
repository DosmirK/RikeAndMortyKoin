package com.example.rikeandmortykoin.repository

import androidx.lifecycle.LiveData
import com.example.rikeandmortykoin.data.CartoonApiService
import com.example.rikeandmortykoin.data.Character
import com.example.rikeandmortykoin.ui.base.BaseRepository
import com.example.rikeandmortykoin.utils.Resource


class CharacterRepository (
    private val api: CartoonApiService
): BaseRepository() {
    suspend fun getCharacterUrl(id: Int): LiveData<Resource<Character>> = performNetworkRequest {
        api.getSingleCharacter(id).body()!!
    }

}
package com.example.rikeandmortykoin.repository

import androidx.lifecycle.LiveData
import com.example.rikeandmortykoin.data.CartoonApiService
import com.example.rikeandmortykoin.data.Character
import com.example.rikeandmortykoin.utils.Resource


class CharacterRepository (
    private val api: CartoonApiService
) {
    fun getCharacterUrl(url: String): LiveData<Resource<Character>> {
        return BaseRepository.performNetworkRequest { api.getSingleCharacter(url) }
    }
}
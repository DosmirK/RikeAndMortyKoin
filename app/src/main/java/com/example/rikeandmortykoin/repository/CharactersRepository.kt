package com.example.rikeandmortykoin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.rikeandmortykoin.data.CartoonApiService
import com.example.rikeandmortykoin.data.Character
import com.example.rikeandmortykoin.data.CharacterResponse
import com.example.rikeandmortykoin.utils.Resource

class CharactersRepository (
    private val api: CartoonApiService
) {

    fun getCharacter(): LiveData<Resource<List<Character>>> {
        val characterLiveData: LiveData<Resource<CharacterResponse>> = BaseRepository.performNetworkRequest { api.getCharacters() }
        return characterLiveData.map { resource ->
            when (resource) {
                is Resource.Success -> {
                    val characterList: List<Character> = resource.data?.results ?: emptyList()
                    Resource.Success(characterList)
                }
                is Resource.Loading -> Resource.Loading()
                is Resource.Error -> Resource.Error(resource.massage ?: "Unknown error")
            }
        }
    }
}
package com.example.rikeandmortykoin.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rikeandmortykoin.data.Character
import com.example.rikeandmortykoin.repository.CharactersRepository

class CharactersViewModel (
    private val repository: CharactersRepository
): ViewModel() {

    val characterList: LiveData<PagingData<Character>> =
        repository.getCharacters()
            .cachedIn(viewModelScope)

}
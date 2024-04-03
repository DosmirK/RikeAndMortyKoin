package com.example.rikeandmortykoin.ui.characters.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rikeandmortykoin.data.Character
import com.example.rikeandmortykoin.repository.CharactersRepository
import com.example.rikeandmortykoin.utils.Resource

class CharactersViewModel (
    private val repository: CharactersRepository
): ViewModel() {

    fun giveCharacters(): LiveData<Resource<List<Character>>> = repository.getCharacter()

}
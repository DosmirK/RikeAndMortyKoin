package com.example.rikeandmortykoin.ui.characters.adapter

import androidx.lifecycle.LiveData
import com.example.rikeandmortykoin.data.Character
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rikeandmortykoin.utils.Resource
import com.example.rikeandmortykoin.repository.Repository

class CharacterViewModel (
    private val repository: Repository
): ViewModel() {

    private var _characters = MutableLiveData<Resource<List<Character>>>()
    val characters: LiveData<Resource<List<Character>>> = _characters

    fun giveCharacters(): LiveData<Resource<List<Character>>> = repository.fetchCharacters()

}
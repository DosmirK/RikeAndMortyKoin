package com.example.rikeandmortykoin.ui.characters.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rikeandmortykoin.data.Character
import com.example.rikeandmortykoin.repository.Repository
import com.example.rikeandmortykoin.utils.Resource

class DetailsViewModel (private val repository: Repository) : ViewModel() {

    private var _characters = MutableLiveData<Resource<Character>>()
    val characters: LiveData<Resource<Character>> = _characters

    fun getData(id: Int): LiveData<Resource<Character>> = repository.getCharacter(id)

    fun getCharacter(url: String): LiveData<Resource<Character>>  = repository.getCharacterUrl(url)

}
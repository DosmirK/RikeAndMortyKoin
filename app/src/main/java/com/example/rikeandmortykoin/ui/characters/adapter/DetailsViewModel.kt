package com.example.rikeandmortykoin.ui.characters.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rikeandmortykoin.data.Character
import com.example.rikeandmortykoin.repository.CharacterRepository
import com.example.rikeandmortykoin.utils.Resource

class DetailsViewModel (private val repository: CharacterRepository) : ViewModel() {

    fun getCharacter(url: String): LiveData<Resource<Character>>  = repository.getCharacterUrl(url)

}
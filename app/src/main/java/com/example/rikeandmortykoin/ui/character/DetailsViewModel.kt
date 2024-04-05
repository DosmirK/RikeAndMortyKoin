package com.example.rikeandmortykoin.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rikeandmortykoin.data.Character
import com.example.rikeandmortykoin.repository.CharacterRepository
import com.example.rikeandmortykoin.utils.Resource

class DetailsViewModel (private val repository: CharacterRepository) : ViewModel() {

    suspend fun getCharacter(id: Int): LiveData<Resource<Character>>  = repository.getCharacterUrl(id)

}
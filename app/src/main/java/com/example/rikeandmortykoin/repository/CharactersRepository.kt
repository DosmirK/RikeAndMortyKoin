package com.example.rikeandmortykoin.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.rikeandmortykoin.data.Character

class CharactersRepository(
    private val charactersPagingSource: CharactersPagingSource
) {
    fun getCharacters(): LiveData<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 200),
        pagingSourceFactory = { charactersPagingSource }
    ).liveData
}
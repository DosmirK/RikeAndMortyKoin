package com.example.rikeandmortykoin.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CartoonApiService {

    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>

    @GET
    suspend fun getSingleCharacter(@Url url: String): Response<Character>

}
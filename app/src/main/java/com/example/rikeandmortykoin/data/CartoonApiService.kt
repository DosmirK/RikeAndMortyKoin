package com.example.rikeandmortykoin.data

import com.example.rikeandmortykoin.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CartoonApiService {

    @GET(BuildConfig.CHARACTER)
    suspend fun getCharactersByPage(
        @Query(BuildConfig.PAGE) page: String
    ): Response<Characters>

    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>

    @GET("character/{id}")
    suspend fun getSingleCharacter(@Path("id") id: Int): Response<Character>

}
package com.example.rikeandmortykoin.data
import com.google.gson.annotations.SerializedName
import java.util.*

class Characters(

    @SerializedName("info")
    val requestInfo: Info,

    @SerializedName("results")
    val characters: List<Character>
)
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String?,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: Date
)

data class Origin(
    val name: String,
    val url: String
)

data class Location(
    val name: String,
    val url: String
)

data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
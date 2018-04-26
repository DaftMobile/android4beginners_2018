package com.daftmobile.android4beginners6pokedex.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface PokedexApi {
    @GET("/api/pokemon/{number}")
    fun getPokemonByNumber(@Path("number") index: Int): Call<Pokemon>

    @GET("/api/pokemon")
    fun getPokemonList(): Call<List<Pokemon>>

    @POST("/api/pokemon/{number}/catch")
    fun catchPokemon(@Path("number") index: Int): Call<Pokemon>
}

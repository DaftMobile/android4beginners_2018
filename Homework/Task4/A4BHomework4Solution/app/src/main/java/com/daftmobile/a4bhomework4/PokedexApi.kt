package com.daftmobile.a4bhomework4

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface PokedexApi {
    @GET("/api/pokemon/{number}/peek")
    fun getPokemonByNumber(@Path("number") index: Int): Call<Pokemon>
}

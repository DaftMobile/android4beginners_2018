package com.daftmobile.a4bhomework4

import android.provider.Settings
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Konrad Kowalewski.
 */
class PokemonFetcher {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://switter.int.daftcode.pl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val pokedexApi = retrofit.create(PokedexApi::class.java)

    fun fetch(index: Int, onSuccess: (Pokemon) -> Unit, onError: (String) -> Unit) {
        val call = pokedexApi.getPokemonByNumber(index)
        call.enqueue(object : Callback<Pokemon> {
            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                onError(t.message ?: "Unknown error")
            }

            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                if (response.isSuccessful) {
                    val pokemon = response.body() ?: return onError("Something went wrong")
                    onSuccess(pokemon)
                } else {
                    onError(response.message())
                }
            }
        })
    }
}
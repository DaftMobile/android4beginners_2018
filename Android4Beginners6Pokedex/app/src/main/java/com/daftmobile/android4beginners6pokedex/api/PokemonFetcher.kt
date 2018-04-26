package com.daftmobile.android4beginners6pokedex.api

import android.provider.Settings
import com.daftmobile.android4beginners6pokedex.api.interceptors.HeaderInterceptor
import com.daftmobile.android4beginners6pokedex.api.interceptors.LoggingInterceptor
import okhttp3.OkHttpClient
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
            .client(createOkHttpClient())
            .baseUrl("https://switter.int.daftcode.pl/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val pokedexApi = retrofit.create(PokedexApi::class.java)

    fun fetchAll(onSuccess: (List<Pokemon>) -> Unit, onError: (String) -> Unit) {
        val call = pokedexApi.getPokemonList()
        call.enqueue(object : Callback<List<Pokemon>> {
            override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
                onError(t.message ?: "Unknown error")
            }

            override fun onResponse(call: Call<List<Pokemon>>, response: Response<List<Pokemon>>) {
                if (response.isSuccessful) {
                    val pokemonList = response.body() ?: return onError("Something went wrong")
                    onSuccess(pokemonList)
                } else {
                    onError(response.message())
                }
            }
        })
    }

    fun catch(index: Int, onSuccess: (Pokemon) -> Unit, onError: (String) -> Unit) {
        val call = pokedexApi.catchPokemon(index)
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

    companion object {
        fun createOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor())
                .addInterceptor(HeaderInterceptor(mapOf("x-device-uuid" to Settings.Secure.ANDROID_ID)))
                .build()
    }
}

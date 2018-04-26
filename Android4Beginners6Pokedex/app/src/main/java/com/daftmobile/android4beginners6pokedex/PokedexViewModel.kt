package com.daftmobile.android4beginners6pokedex

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.daftmobile.android4beginners6pokedex.api.PokemonFetcher

/**
 * Created by Konrad Kowalewski.
 */
class PokedexViewModel: ViewModel() {
    private val pokemonFetcher = PokemonFetcher()

    private val pokemonLiveData = MutableLiveData<List<PokemonItem>>()
    private val errorLiveData = MutableLiveData<String>()
    // TODO: loader

    fun pokemonList(): LiveData<List<PokemonItem>> = pokemonLiveData
    fun error(): LiveData<String> = errorLiveData

    fun refresh() {
        pokemonFetcher.fetchAll({
            pokemonLiveData.value = it.map { PokemonItem(it) }
            pokemonLiveData.value = null
        }, {
            errorLiveData.setValue(it)
        })
    }

}
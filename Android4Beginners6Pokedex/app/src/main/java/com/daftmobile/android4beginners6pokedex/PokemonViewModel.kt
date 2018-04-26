package com.daftmobile.android4beginners6pokedex

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.daftmobile.android4beginners6pokedex.api.PokemonFetcher

/**
 * Created by Konrad Kowalewski.
 */
class PokemonViewModel: ViewModel() {
    private val pokemonFetcher = PokemonFetcher()

    private val pokemonLiveData = MutableLiveData<PokemonItem>()
    private val errorLiveData = MutableLiveData<String>()
    // TODO: button enabled

    fun pokemonInfo(): LiveData<PokemonItem> = pokemonLiveData
    fun error(): LiveData<String> = errorLiveData

    fun setPokemonItem(pokemonItem: PokemonItem) {
        pokemonLiveData.value = pokemonItem
    }

    fun catchPokemon() {
        val index = pokemonLiveData.value?.index ?: return
        pokemonFetcher.catch(index, {
            val pokemonItem = PokemonItem(it)
            setPokemonItem(pokemonItem)
        }, {
            errorLiveData.setValue(it)
        })
    }
}
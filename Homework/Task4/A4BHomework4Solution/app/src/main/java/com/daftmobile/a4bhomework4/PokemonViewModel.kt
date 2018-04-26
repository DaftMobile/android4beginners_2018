package com.daftmobile.a4bhomework4

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by Konrad Kowalewski.
 */
class PokemonViewModel: ViewModel() {
    private val pokemonFetcher = PokemonFetcher()

    private val pokemonLiveData = MutableLiveData<PokemonItem>()
    private val errorLiveData = MutableLiveData<String>()

    fun newPokemon(): LiveData<PokemonItem> = pokemonLiveData
    fun error(): LiveData<String> = errorLiveData

    fun showPokemonInfo(index: String) {
        pokemonFetcher.fetch(index.toInt(), {
            pokemonLiveData.value = PokemonItem(it.number.toString(), it.name, it.color)
            pokemonLiveData.value = null
        }, {
            errorLiveData.postValue(it)
        })
    }
}
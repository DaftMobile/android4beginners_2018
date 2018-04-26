package com.daftmobile.android4beginners6pokedex

import android.support.annotation.ColorInt
import com.daftmobile.android4beginners6pokedex.api.Pokemon
import java.io.Serializable

data class PokemonItem(val index: Int, val numberLabel: String, val name: String, @ColorInt val color: Int): Serializable {
    constructor(pokemon: Pokemon): this(pokemon.number, String.format("#%03d", pokemon.number), pokemon.name, pokemon.color or 0xff000000.toInt())

//    val thumbnailUrl = "https://switter.int.daftcode.pl/api/pokemon/$index/thumbnail"
//    val imageUrl = "https://switter.int.daftcode.pl/api/pokemon/$index/image"
}

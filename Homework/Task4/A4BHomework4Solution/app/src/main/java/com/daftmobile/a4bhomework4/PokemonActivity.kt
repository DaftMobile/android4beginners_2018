package com.daftmobile.a4bhomework4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pokemon.*

class PokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        val pokemonItem = intent.getSerializableExtra(EXTRA_KEY) as PokemonItem

        title = pokemonItem.name
        nameView.text = pokemonItem.name
        numberView.text = pokemonItem.index
        imageView.setBackgroundColor(pokemonItem.backgroundColor)
    }

    companion object {
        const val EXTRA_KEY = "pokemon_extra"
    }
}

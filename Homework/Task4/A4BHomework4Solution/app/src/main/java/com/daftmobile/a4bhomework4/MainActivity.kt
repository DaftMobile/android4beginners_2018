package com.daftmobile.a4bhomework4

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)
        viewModel.newPokemon().observe(this, Observer(this::showPokemonActivity))
        viewModel.error().observe(this, Observer(this::showError))

        showInfoButton.setOnClickListener {
            viewModel.showPokemonInfo(pokedexIndexInput.text.toString())
        }
    }

    private fun showPokemonActivity(pokemon: PokemonItem?) {
        if (pokemon == null) return
        val intent = Intent(this, PokemonActivity::class.java)
                .putExtra(PokemonActivity.EXTRA_KEY, pokemon)
        startActivity(intent)
    }

    private fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

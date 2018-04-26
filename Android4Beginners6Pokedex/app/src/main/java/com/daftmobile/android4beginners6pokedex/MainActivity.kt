package com.daftmobile.android4beginners6pokedex

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.daftmobile.android4beginners6pokedex.recycler.PokemonAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PokedexViewModel
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(PokedexViewModel::class.java)
        viewModel.pokemonList().observe(this, Observer(this::updatePokemonList))
        viewModel.error().observe(this, Observer(this::showError))

        pokedexRecyclerView.layoutManager = GridLayoutManager(this, 3)
        pokemonAdapter = PokemonAdapter(emptyList(), this::showPokemonActivity)
        pokedexRecyclerView.adapter = pokemonAdapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }

    private fun updatePokemonList(pokemonList: List<PokemonItem>?) {
        if (pokemonList == null) return
        pokemonAdapter.items = pokemonList
        pokemonAdapter.notifyDataSetChanged()
    }

    private fun showPokemonActivity(pokemon: PokemonItem) {
        val intent = Intent(this, PokemonActivity::class.java)
                .putExtra(PokemonActivity.EXTRA_KEY, pokemon)
        startActivity(intent)
    }

    private fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

package com.daftmobile.android4beginners6pokedex.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.daftmobile.android4beginners6pokedex.PokemonItem
import com.daftmobile.android4beginners6pokedex.R

/**
 * Created by Konrad Kowalewski.
 */
open class PokemonAdapter(var items: List<PokemonItem>, private val onItemClicked: (PokemonItem) -> Unit): RecyclerView.Adapter<PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_recycler_view_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) = holder.bindItem(items[position], onItemClicked)

    override fun getItemCount() = items.size
}
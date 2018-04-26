package com.daftmobile.android4beginners6pokedex.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import com.daftmobile.android4beginners6pokedex.PokemonItem
import kotlinx.android.synthetic.main.pokemon_recycler_view_item.view.*

/**
 * Created by Konrad Kowalewski.
 */
class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView = itemView.imageView
    private val nameView = itemView.nameView
    private val numberView = itemView.numberView
    private val colorView = itemView.colorView

    fun bindItem(pokemonItem: PokemonItem, onItemClicked: (PokemonItem) -> Unit) {
        nameView.text = pokemonItem.name
        numberView.text = pokemonItem.numberLabel
        colorView.setBackgroundColor(pokemonItem.color)
        // TODO: thumbnail
        itemView.setOnClickListener { onItemClicked(pokemonItem) }
    }
}
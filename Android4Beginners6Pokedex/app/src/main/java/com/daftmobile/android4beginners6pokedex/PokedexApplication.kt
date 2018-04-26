@file:Suppress("unused")

package com.daftmobile.android4beginners6pokedex

import android.app.Application
import com.daftmobile.android4beginners6pokedex.api.PokemonFetcher
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

/**
 * Created by Konrad Kowalewski.
 */
class PokedexApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        setupPicasso()
    }

    private fun setupPicasso() {
        val picasso = Picasso.Builder(this)
                .downloader(OkHttp3Downloader(PokemonFetcher.createOkHttpClient()))
                .build()
        Picasso.setSingletonInstance(picasso)
    }
}
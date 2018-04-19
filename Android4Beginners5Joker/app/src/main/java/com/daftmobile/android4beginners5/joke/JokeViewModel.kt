package com.daftmobile.android4beginners5.joke

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.daftmobile.android4beginners5.joke.gson.GsonJokeFetcher
import com.daftmobile.android4beginners5.log


class JokeViewModel: ViewModel() {
    private val fetcher = JokeFetcher()

    private val responseLiveData = MutableLiveData<String>()
    private val errorLiveData = MutableLiveData<String>()
    private val loaderVisibleData = MutableLiveData<Boolean>()

    fun response(): LiveData<String> = responseLiveData
    fun error(): LiveData<String> = errorLiveData
    fun loaderVisible(): LiveData<Boolean> = loaderVisibleData

    fun call() {
        // TODO
    }

    private fun doSomeThreading() {
        log("Funny stuff from ${Thread.currentThread().name} thread")
        Thread {
            Thread.sleep(3000)
            log("Response from ${Thread.currentThread().name} thread")
            responseLiveData.value = "Akuku"
        }.start()
    }

    private fun fetchDataFromApi() {
        fetcher.fetch({
            responseLiveData.setValue(it)
        })
    }
}
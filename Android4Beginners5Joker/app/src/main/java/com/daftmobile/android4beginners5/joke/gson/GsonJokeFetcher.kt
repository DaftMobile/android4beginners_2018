package com.daftmobile.android4beginners5.joke.gson

import android.provider.Settings
import com.daftmobile.android4beginners5.joke.JokeApi
import com.daftmobile.android4beginners5.joke.interceptors.HeaderInterceptor
import com.daftmobile.android4beginners5.joke.interceptors.LoggingInterceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class GsonJokeFetcher {

    private val client = OkHttpClient.Builder()
            .addInterceptor(LoggingInterceptor())
            .addInterceptor(HeaderInterceptor(mapOf("x-device-uuid" to Settings.Secure.ANDROID_ID)))
            .build()

    private val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://switter.int.daftcode.pl/")
//            .addConverterFactory(GsonConverterFactory.create())
            .build()

//    private val jokeApi = retrofit.create(JokeApi::class.java)

    fun fetch(onSuccess: (Joke) -> Unit, onError: (String) -> Unit) {
//        val call = jokeApi.joke()
//        call.enqueue(object : Callback<ResponseBody> {
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                onError(t.message ?: "Unknown error")
//            }
//
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                if (response.isSuccessful)  {
//                    val body = response.body()?.string() ?: return
//                } else {
//                    onError(response.message())
//                }
//            }
//        })
    }
}
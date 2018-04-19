package com.daftmobile.android4beginners5.joke

import com.daftmobile.android4beginners5.joke.interceptors.LoggingInterceptor
import com.daftmobile.android4beginners5.log
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class JokeFetcher {

    private val client = OkHttpClient.Builder()
            .addInterceptor(LoggingInterceptor())
            .build()

    private val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://switter.int.daftcode.pl/")
            .build()

    private val jokeApi = retrofit.create(JokeApi::class.java)

    fun fetch(onSuccess: (String) -> Unit) {
//        call.enqueue(object : Callback<ResponseBody> {
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                log(t.message ?: "Unknown error")
//            }
//
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                onSuccess(response.body()?.string() ?: return)
//            }
//        })
    }
}
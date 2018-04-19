package com.daftmobile.android4beginners5.joke.interceptors

import com.daftmobile.android4beginners5.log
import okhttp3.Interceptor
import okhttp3.Response

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        log(chain.request().toString())
        val response = chain.proceed(chain.request())
        log(response.toString())
        return response
    }
}
package com.daftmobile.android4beginners6pokedex.api.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(private val headers: Map<String, String>) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        headers.entries.forEach { requestBuilder.addHeader(it.key, it.value) }
        return chain.proceed(requestBuilder.build())
    }
}
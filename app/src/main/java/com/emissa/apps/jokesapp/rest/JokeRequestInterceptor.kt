package com.emissa.apps.jokesapp.rest

import okhttp3.Interceptor
import okhttp3.Response

class JokeRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        return chain.proceed(request)
    }
}
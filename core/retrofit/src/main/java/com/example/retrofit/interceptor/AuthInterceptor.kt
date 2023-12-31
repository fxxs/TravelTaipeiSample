package com.example.retrofit.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("accept", "application/json")
            .build()

        return chain.proceed(newRequest)
    }
}
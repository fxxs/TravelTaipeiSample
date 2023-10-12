package com.example.retrofit.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class CurlPrinterInterceptor @Inject constructor(private val generator: RetrofitCurlGenerator) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val logger = HttpLoggingInterceptor.Logger.DEFAULT
        logger.log("==> CURL COMMAND: ${request.url}")
        logger.log(" ${generator.curlCommandForRequest(request)}\n")
        logger.log("==> END CURL COMMAND")
        return chain.proceed(request)
    }
}
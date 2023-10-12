package com.example.retrofit.di

import com.example.retrofit.BuildConfig
import com.example.retrofit.ResultCallAdapterFactory
import com.example.retrofit.api.AttractionsApi
import com.example.retrofit.api.EventsApi
import com.example.retrofit.api.MediaApi
import com.example.retrofit.api.MiscellaneousApi
import com.example.retrofit.api.TourApi
import com.example.retrofit.interceptor.AuthInterceptor
import com.example.retrofit.interceptor.CurlPrinterInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RetrofitProvideModule {

    @Singleton
    @Provides
    fun provideRetrofitClient(
        loggingInterceptor: HttpLoggingInterceptor,
        curlInterceptor: CurlPrinterInterceptor,
    ): Retrofit {
        val baseUrl: String = BuildConfig.BASE_URL

        val clientBuilder = OkHttpClient
            .Builder()
            .callTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(AuthInterceptor())

        if (BuildConfig.BUILD_TYPE == "debug") {
            clientBuilder.addInterceptor(loggingInterceptor)
            clientBuilder.addInterceptor(curlInterceptor)
        }

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ResultCallAdapterFactory())
            .client(clientBuilder.build())
            .build()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().also { it.setLevel(HttpLoggingInterceptor.Level.BODY) }
    }

    @Singleton
    @Provides
    fun provideAttractionsApi(retrofit: Retrofit): AttractionsApi =
        retrofit.create(AttractionsApi::class.java)

    @Singleton
    @Provides
    fun provideEventsApi(retrofit: Retrofit): EventsApi =
        retrofit.create(EventsApi::class.java)

    @Singleton
    @Provides
    fun provideMediaApi(retrofit: Retrofit): MediaApi =
        retrofit.create(MediaApi::class.java)

    @Singleton
    @Provides
    fun provideMiscellaneousApi(retrofit: Retrofit): MiscellaneousApi =
        retrofit.create(MiscellaneousApi::class.java)

    @Singleton
    @Provides
    fun provideTourApi(retrofit: Retrofit): TourApi =
        retrofit.create(TourApi::class.java)
}
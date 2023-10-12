package com.example.repository.di

import android.content.SharedPreferences
import com.example.repository.AttractionsRepository
import com.example.repository.ConfigRepository
import com.example.repository.EventsRepository
import com.example.repository.MediaRepository
import com.example.repository.MiscellaneousRepository
import com.example.repository.TourRepository
import com.example.retrofit.api.AttractionsApi
import com.example.retrofit.api.EventsApi
import com.example.retrofit.api.MediaApi
import com.example.retrofit.api.MiscellaneousApi
import com.example.retrofit.api.TourApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryProvideModule {
    @Provides
    @Singleton
    fun provideConfigRepository(
        sharedPreferences: SharedPreferences,
    ): ConfigRepository {
        return ConfigRepository(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideAttractionsRepository(
        attractionsApi: AttractionsApi
    ): AttractionsRepository {
        return AttractionsRepository(attractionsApi)
    }

    @Provides
    @Singleton
    fun provideEventsRepository(
        eventsApi: EventsApi
    ): EventsRepository {
        return EventsRepository(eventsApi)
    }

    @Provides
    @Singleton
    fun provideMediaRepository(
        mediaApi: MediaApi
    ): MediaRepository {
        return MediaRepository(mediaApi)
    }

    @Provides
    @Singleton
    fun provideMiscellaneousRepository(
        miscellaneousApi: MiscellaneousApi
    ): MiscellaneousRepository {
        return MiscellaneousRepository(miscellaneousApi)
    }

    @Provides
    @Singleton
    fun provideTourRepository(
        tourApi: TourApi
    ): TourRepository {
        return TourRepository(tourApi)
    }
}
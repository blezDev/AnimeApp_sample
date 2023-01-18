package com.example.noteapp.di

import com.example.noteapp.network.AnimeAPI
import com.example.noteapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun getRetrofit() : retrofit2.Retrofit{
        return retrofit2.Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun getAnimeAPI(retrofit: Retrofit) : AnimeAPI{
        return  retrofit.create(AnimeAPI::class.java)
    }

}

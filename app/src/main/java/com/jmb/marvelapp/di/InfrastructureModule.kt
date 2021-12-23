package com.jmb.marvelapp.di

import android.app.Application
import androidx.room.Room
import com.jmb.infrastructure.database.AppDatabase
import com.jmb.infrastructure.server.TheMarvelDb
import com.jmb.marvelapp.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InfrastructureModule {

    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(app: Application): String = app.getString(R.string.apiKey)

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider(): String = "https://gateway.marvel.com/v1/public/"

    @Provides
    @Singleton
    @Named("hash")
    fun hashProvider(): String = "fe2f99e22ffdfcafd0723eee722abf45"

    @Provides
    @Singleton
    fun theMarvel(@Named("baseUrl") baseUrl: String) = TheMarvelDb(baseUrl)

    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "marvel-app"
    ).build()

}
package com.jmb.marvelapp.di

import com.jmb.domain.service.SerieService
import com.jmb.infrastructure.database.AppDatabase
import com.jmb.infrastructure.repository.InternetRepository
import com.jmb.infrastructure.repository.SerieProxy
import com.jmb.infrastructure.repository.SerieRetrofitRepository
import com.jmb.infrastructure.repository.SerieRoomRepository
import com.jmb.infrastructure.server.TheMarvelDb
import com.jmb.marvelapp.AndroidCheckedInternet
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun seriesServiceProvider(serieProxy: SerieProxy): SerieService = SerieService(serieProxy)

    @Provides
    fun serieRoomProvider(db: AppDatabase): SerieRoomRepository = SerieRoomRepository(db)

    @Provides
    fun serieRetrofitProvider(
        theMarvelDb: TheMarvelDb,
        @Named("apiKey") apikey: String,
        @Named("hash") hash: String
    ): SerieRetrofitRepository =
        SerieRetrofitRepository(theMarvelDb, apikey, hash)

    @Provides
    fun internetProvider(androidCheckedInternet: AndroidCheckedInternet): InternetRepository =
        InternetRepository(androidCheckedInternet)


}
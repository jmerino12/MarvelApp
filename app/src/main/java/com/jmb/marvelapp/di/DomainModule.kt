package com.jmb.marvelapp.di

import com.jmb.domain.aggregates.Character
import com.jmb.domain.aggregates.Serie
import com.jmb.domain.service.CharacterService
import com.jmb.domain.service.SerieService
import com.jmb.infrastructure.database.AppDatabase
import com.jmb.infrastructure.repository.*
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
    fun seriesServiceProvider(serieProxy: SerieRemoteProxy<Serie>): SerieService =
        SerieService(serieProxy)

    /*  @Provides
      fun characterServiceProvider(
          characterProxy: CharacterProxy,
          characterRoomRepository: CharacterRoomRepository
      ): CharacterService =
          CharacterService(characterProxy, localRepository = characterRoomRepository)

      @Provides
      fun characterRoomProvider(db: AppDatabase): CharacterRoomRepository =
          CharacterRoomRepository(db)

     @Provides
      fun characterRetrofitProvider(
          theMarvelDb: TheMarvelDb,
          @Named("apiKey") apikey: String,
          @Named("hash") hash: String
      ): CharacterRetrofitRepository =
          CharacterRetrofitRepository(theMarvelDb, apikey, hash)*/

    @Provides
    fun serieRetrofitProvider(
        theMarvelDb: TheMarvelDb,
        @Named("apiKey") apikey: String,
        @Named("hash") hash: String
    ): SerieRetrofitRepository<Serie> =
        SerieRetrofitRepository(theMarvelDb, apikey, hash)

    @Provides
    fun serieRoomProvider(db: AppDatabase): SerieRoomRepository = SerieRoomRepository(db)

    @Provides
    fun internetProvider(androidCheckedInternet: AndroidCheckedInternet): InternetRepository =
        InternetRepository(androidCheckedInternet)


}
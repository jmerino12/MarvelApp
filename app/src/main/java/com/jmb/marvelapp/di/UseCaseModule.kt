package com.jmb.marvelapp.di

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.service.CharacterService
import com.jmb.domain.service.SerieService
import com.jmb.usecase.character.FindCharacter
import com.jmb.usecase.character.GetCharacters
import com.jmb.usecase.serie.GetSeries
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun getSeriesProvider(service: SerieService): GetSeries = GetSeries(service)

    /*@Provides
    fun getCharacterProvider(service: CharacterService): GetCharacters = GetCharacters(service)

    @Provides
    fun getCharacteProvider(service: CharacterService): FindCharacter = FindCharacter(service)*/
}
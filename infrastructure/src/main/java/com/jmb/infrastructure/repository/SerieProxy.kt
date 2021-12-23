package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.SerieRepository
import javax.inject.Inject

class SerieProxy @Inject constructor(
    private val remoteRepository: SerieRetrofitRepository,
    private val localRepository: SerieRoomRepository,
    private val internetRepository: InternetRepository
) : SerieRepository {


    override suspend fun getAll(): List<Serie> {
        if (internetRepository.checkConnectionInternet()) {
            if (localRepository.isEmpty()) {
                val series = remoteRepository.getSeries()
                localRepository.saveSeries(series)
            }
        }
        return localRepository.getAll()
    }
}
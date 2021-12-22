package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.SerieRepository

class SerieProxy(
    private val remoteRepository: SerieRetrofitRepository,
    private val localRepository: SerieRoomRepository
) : SerieRepository {


    override suspend fun getAll(): List<Serie> {
        if (localRepository.isEmpty()) {
            val series = remoteRepository.getSeries(
                apiKey = "4a1434b727e8bfa82a978ffd281c6bed",
                hash = "fe2f99e22ffdfcafd0723eee722abf45",
                ts = "1"
            )
            localRepository.saveSeries(series)
        }
        return localRepository.getAll()
    }
}
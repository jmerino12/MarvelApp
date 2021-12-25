package com.jmb.domain.service

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.SerieRemoteRepository

class SerieService(
    private val remoteRepository: SerieRemoteRepository<Serie>,
) {

    suspend fun getSeries(): List<Serie> {
        return remoteRepository.getAll()
    }
}
package com.jmb.domain.service

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.SerieRemoteRepository

class SerieService(
    private val repository: SerieRemoteRepository
) {
    suspend fun getSeries(): List<Serie> {
        return repository.getSeries("apiKey", "hash", "ts")
    }
}
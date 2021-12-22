package com.jmb.domain.service

import com.jmb.domain.repository.SerieRemoteRepository

class SerieService(
    private val repository: SerieRemoteRepository
) {
    suspend fun getSeries() {
        repository.getSeries("apiKey", "hash", "ts")
    }
}
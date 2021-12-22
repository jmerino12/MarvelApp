package com.jmb.domain.service

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.SerieRepository

class SerieService(
    private val repository: SerieRepository,
) {

    suspend fun getSeries(): List<Serie> {
        return repository.getAll()
    }
}
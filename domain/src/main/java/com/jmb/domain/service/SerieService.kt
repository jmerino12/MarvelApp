package com.jmb.domain.service

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.WebSeviceRepository

class SerieService(
    private val remoteRepository: WebSeviceRepository<Serie>,
) {

    suspend fun getSeries(): List<Serie> {
        return remoteRepository.getAll()
    }
}
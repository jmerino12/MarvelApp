package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.LocalRepository
import com.jmb.domain.repository.WebSeviceRepository

import javax.inject.Inject

class SerieRemoteProxy @Inject constructor(
    private val remoteRepository: SerieRetrofitRepository,
    private val localRepository: LocalRepository<Serie>,
    private val internetRepository: InternetRepository
) : WebSeviceRepository<Serie> {


    override suspend fun getAll(): List<Serie> {
        if (internetRepository.checkConnectionInternet()) {
            if (localRepository.isEmpty()) {
                val series = remoteRepository.getAll()
                localRepository.save(series)
            }
        }
        return localRepository.getAll()
    }
}
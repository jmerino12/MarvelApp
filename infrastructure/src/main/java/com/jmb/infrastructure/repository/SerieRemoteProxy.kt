package com.jmb.infrastructure.repository

import com.jmb.domain.repository.LocalRepository
import com.jmb.domain.repository.WebSeviceRepository
import javax.inject.Inject

class SerieRemoteProxy<T> @Inject constructor(
    private val remoteRepository: SerieRetrofitRepository<T>,
    private val localRepository: LocalRepository<T>,
    private val internetRepository: InternetRepository
) : WebSeviceRepository<T> {


    override suspend fun getAll(): List<T> {
        if (internetRepository.checkConnectionInternet()) {
            if (localRepository.isEmpty()) {
                val series = remoteRepository.getAll()
                localRepository.save(series)
            }
        }
        return localRepository.getAll()
    }
}
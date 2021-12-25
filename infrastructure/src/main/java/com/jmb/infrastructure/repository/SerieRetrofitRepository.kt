package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.SerieRemoteRepository
import com.jmb.infrastructure.anticorruption.toDomain
import com.jmb.infrastructure.server.TheMarvelDb
import javax.inject.Inject

class SerieRetrofitRepository @Inject constructor(
    private val theMarvelDb: TheMarvelDb,
    private val apiKey: String,
    private val hash: String
) :
    SerieRemoteRepository<Serie> {

    override suspend fun getAll(): List<Serie> {
        return theMarvelDb.service.listSeries(apiKey, hash, "1")
            .data.results.map { it.toDomain() }
    }
}

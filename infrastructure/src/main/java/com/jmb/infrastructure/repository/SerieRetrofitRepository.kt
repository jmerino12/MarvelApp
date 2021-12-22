package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.SerieRemoteRepository
import com.jmb.infrastructure.anticorruption.toDomain
import com.jmb.infrastructure.server.TheMarvelDb

class SerieRetrofitRepository(private val theMarvelDb: TheMarvelDb) : SerieRemoteRepository {

    override suspend fun getSeries(apiKey: String, hash: String, ts: String): List<Serie> {
        return theMarvelDb.service.listSeries(apiKey, hash, ts)
            .data.results.map { it.toDomain() }
    }
}

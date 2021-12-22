package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.SerieRemoteRepository
import com.jmb.infrastructure.anticorruption.toDomain
import com.jmb.infrastructure.server.TheMarvelDb

class SerieRepository(
    private val theSerieDb: TheMarvelDb
) : SerieRemoteRepository {

    override suspend fun getSeries(apiKey: String, hash: String, ts: String): List<Serie> =
        theSerieDb.service.listSeries(
            "4a1434b727e8bfa82a978ffd281c6bed",
            "fe2f99e22ffdfcafd0723eee722abf45",
            "1"
        ).data.results.map { it.toDomain() }

}
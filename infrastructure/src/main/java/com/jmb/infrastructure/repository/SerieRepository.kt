package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.SerieRemoteRepository
import com.jmb.infrastructure.anticorruption.toDomain
import com.jmb.infrastructure.anticorruption.toRoom
import com.jmb.infrastructure.database.dao.MarvelDao
import com.jmb.infrastructure.server.TheMarvelDb

class SerieRepository(
    private val theSerieDb: TheMarvelDb,
    private val dao: MarvelDao
) : SerieRemoteRepository {

    override suspend fun getSeries(apiKey: String, hash: String, ts: String): List<Serie> {
        if (dao.serieCount() <= 0) {
            val series = theSerieDb.service.listSeries(
                "4a1434b727e8bfa82a978ffd281c6bed",
                "fe2f99e22ffdfcafd0723eee722abf45",
                "1"
            ).data.results.map { it.toDomain() }
            dao.insertSeries(series.map { it.toRoom() })
        }
        return dao.getAll().map { it.toDomain() }
    }


}
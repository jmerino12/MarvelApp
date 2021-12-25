package com.jmb.infrastructure.repository

import com.jmb.domain.repository.WebSeviceRepository
import com.jmb.infrastructure.server.TheMarvelDb
import javax.inject.Inject

class SerieRetrofitRepository<T> @Inject constructor(
    private val theMarvelDb: TheMarvelDb,
    private val apiKey: String,
    private val hash: String
) : WebSeviceRepository<T> {

    override suspend fun getAll(): List<T> {
        return theMarvelDb.service.listSeries<T>(apiKey, hash, "1")
            .data.results
    }
}

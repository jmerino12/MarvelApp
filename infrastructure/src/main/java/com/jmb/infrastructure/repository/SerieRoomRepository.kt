package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.SerieLocalRepository
import com.jmb.infrastructure.anticorruption.toDomain
import com.jmb.infrastructure.anticorruption.toRoom
import com.jmb.infrastructure.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SerieRoomRepository @Inject constructor(db: AppDatabase) : SerieLocalRepository {
    private val marvelDao = db.marvelDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { marvelDao.serieCount() <= 0 }

    override suspend fun saveSeries(series: List<Serie>) = withContext(Dispatchers.IO) {
        marvelDao.insertSeries(series.map { it.toRoom() })
    }

    override suspend fun getAll(): List<Serie> = withContext(Dispatchers.IO) {
        marvelDao.getAll().map {
            it.toDomain()
        }
    }

    override suspend fun findById(id: Int): Serie = withContext(Dispatchers.IO) {
        marvelDao.getSerieById(id).toDomain()
    }


}
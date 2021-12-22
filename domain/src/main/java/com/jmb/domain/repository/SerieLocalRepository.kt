package com.jmb.domain.repository

import com.jmb.domain.aggregates.Serie

interface SerieLocalRepository {
    suspend fun isEmpty(): Boolean
    suspend fun saveSeries(series: List<Serie>)
    suspend fun getAll(): List<Serie>
    suspend fun findById(id: Int): Serie
}
package com.jmb.domain.repository

import com.jmb.domain.aggregates.Serie


interface SerieLocalRepository {
    suspend fun isEmpty(): Boolean
    suspend fun save(data: List<Serie>)
    suspend fun getAll(): List<Serie>
}
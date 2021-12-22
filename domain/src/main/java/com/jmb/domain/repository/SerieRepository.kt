package com.jmb.domain.repository

import com.jmb.domain.aggregates.Serie

interface SerieRepository {
    suspend fun getAll(): List<Serie>
}
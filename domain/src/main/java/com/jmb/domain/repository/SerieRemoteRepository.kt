package com.jmb.domain.repository

import com.jmb.domain.aggregates.Serie

interface SerieRemoteRepository {
    suspend fun getSeries(): List<Serie>
}
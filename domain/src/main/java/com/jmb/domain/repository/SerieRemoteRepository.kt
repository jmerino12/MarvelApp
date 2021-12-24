package com.jmb.domain.repository

import com.jmb.domain.aggregates.Serie

interface SerieRemoteRepository<T> {
    suspend fun getData(): List<T>
}
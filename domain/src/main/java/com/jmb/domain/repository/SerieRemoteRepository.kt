package com.jmb.domain.repository



interface SerieRemoteRepository<T> {
    suspend fun getAll(): List<T>
}
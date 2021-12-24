package com.jmb.domain.repository


interface SerieRepository<T> {
    suspend fun getAll(): List<T>
}
package com.jmb.domain.repository


interface SerieLocalRepository<T> {
    suspend fun isEmpty(): Boolean
    suspend fun save(data: List<T>)
    suspend fun getAll(): List<T>
    suspend fun findById(id: Int): T
}
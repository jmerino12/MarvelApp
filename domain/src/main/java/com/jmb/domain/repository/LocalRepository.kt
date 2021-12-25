package com.jmb.domain.repository

interface LocalRepository<T> {
    suspend fun isEmpty(): Boolean
    suspend fun save(data: List<T>)
    suspend fun getAll(): List<T>
}
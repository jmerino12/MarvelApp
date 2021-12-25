package com.jmb.domain.repository


interface WebSeviceRepository<T> {
    suspend fun getAll(): List<T>
}
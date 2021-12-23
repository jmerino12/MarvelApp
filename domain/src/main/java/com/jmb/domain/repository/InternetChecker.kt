package com.jmb.domain.repository

interface InternetChecker {
    suspend fun check(): Boolean
}
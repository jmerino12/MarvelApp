package com.jmb.infrastructure.repository

import com.jmb.domain.repository.InternetChecker

class InternetRepository(
    private val permissionChecker: InternetChecker
) {
    suspend fun checkConnectionInternet(): Boolean {
        return permissionChecker.check()
    }
}


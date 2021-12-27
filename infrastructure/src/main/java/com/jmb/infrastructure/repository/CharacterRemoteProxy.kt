package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Character
import com.jmb.domain.aggregates.Serie
import com.jmb.domain.repository.LocalRepository
import com.jmb.domain.repository.WebSeviceRepository
import javax.inject.Inject

class CharacterRemoteProxy @Inject constructor(
    private val remoteRepository: CharacterRetrofitRepository,
    private val localRepository: LocalRepository<Character>,
    private val internetRepository: InternetRepository
) : WebSeviceRepository<Character> {


    override suspend fun getAll(): List<Character> {
        if (internetRepository.checkConnectionInternet()) {
            if (localRepository.isEmpty()) {
                val series = remoteRepository.getAll()
                localRepository.save(series)
            }
        }
        return localRepository.getAll()
    }
}
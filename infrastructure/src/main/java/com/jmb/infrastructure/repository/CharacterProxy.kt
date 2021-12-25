package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Character
import com.jmb.domain.repository.SerieRemoteRepository
import javax.inject.Inject

class CharacterProxy @Inject constructor(
    private val remoteRepository: CharacterRetrofitRepository,
    private val localRepository: CharacterRoomRepository,
    private val internetRepository: InternetRepository
) : SerieRemoteRepository<Character> {


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
package com.jmb.domain.service

import com.jmb.domain.aggregates.Character
import com.jmb.domain.repository.CharacterLocalRepository
import com.jmb.domain.repository.WebSeviceRepository

class CharacterService(
    private val remoteRepository: WebSeviceRepository<Character>,
    private val localRepository: CharacterLocalRepository,
) {

    suspend fun getCharacters(): List<Character> {
        return remoteRepository.getAll()
    }

    suspend fun getCharacter(id: Int): Character {
        return localRepository.findById(id)
    }

}
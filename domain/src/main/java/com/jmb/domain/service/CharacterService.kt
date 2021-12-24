package com.jmb.domain.service

import com.jmb.domain.aggregates.Character
import com.jmb.domain.repository.SerieRepository

class CharacterService(
    private val repository: SerieRepository<Character>,
) {

    suspend fun getCharacters(): List<Character> {
        return repository.getAll()
    }
}
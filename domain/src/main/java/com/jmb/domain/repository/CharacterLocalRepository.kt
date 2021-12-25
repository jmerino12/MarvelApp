package com.jmb.domain.repository

import com.jmb.domain.aggregates.Character


interface CharacterLocalRepository {
    suspend fun isEmpty(): Boolean
    suspend fun save(characters: List<Character>)
    suspend fun getAll(): List<Character>
    suspend fun findById(id: Int): Character

}
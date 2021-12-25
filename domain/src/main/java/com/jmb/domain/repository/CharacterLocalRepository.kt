package com.jmb.domain.repository

import com.jmb.domain.aggregates.Character


interface CharacterLocalRepository {
    suspend fun findById(id: Int): Character
}
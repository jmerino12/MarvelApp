package com.jmb.usecase.character

import com.jmb.domain.aggregates.Character
import com.jmb.domain.service.CharacterService

class FindCharacter(private val characterService: CharacterService) {
    suspend fun invoke(id: Int): Character = characterService.getCharacter(id)
}
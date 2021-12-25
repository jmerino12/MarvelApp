package com.jmb.usecase.character

import com.jmb.domain.aggregates.Character
import com.jmb.domain.service.CharacterService

class GetCharacters(private val characterService: CharacterService) {
    suspend fun invoke(): List<Character> = characterService.getCharacters()
}
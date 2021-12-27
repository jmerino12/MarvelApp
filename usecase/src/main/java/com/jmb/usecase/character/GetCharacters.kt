package com.jmb.usecase.character

import com.jmb.domain.aggregates.Character
import com.jmb.domain.service.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCharacters(private val characterService: CharacterService) {
    suspend fun invoke(): List<Character> =
        withContext(Dispatchers.IO) { characterService.getCharacters() }
}
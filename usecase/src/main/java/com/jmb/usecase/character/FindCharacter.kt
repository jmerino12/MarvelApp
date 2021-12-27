package com.jmb.usecase.character

import com.jmb.domain.aggregates.Character
import com.jmb.domain.service.CharacterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FindCharacter(private val characterService: CharacterService) {
    suspend fun invoke(id: Int): Character =
        withContext(Dispatchers.IO) { characterService.getCharacter(id) }
}
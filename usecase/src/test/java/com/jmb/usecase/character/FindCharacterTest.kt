package com.jmb.usecase.character

import com.jmb.domain.aggregates.Character
import com.jmb.domain.aggregates.Thumbnail
import com.jmb.domain.service.CharacterService
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FindCharacterTest {
    @Mock
    private lateinit var characterService: CharacterService

    private lateinit var findCharacter: FindCharacter

    @Before
    fun setUp() {
        findCharacter = FindCharacter(characterService)
    }

    @Test
    fun getCharacterById_success() = runBlocking {
        val character = Character(
            id = 1,
            name = "",
            description = "",
            modified = "",
            thumbnail = Thumbnail("jpg", ""),
            ""
        )
        whenever(characterService.getCharacter(1)).thenReturn(character)
        val result = findCharacter.invoke(1)
        Assert.assertEquals(character, result)
    }

}
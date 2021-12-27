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
class GetCharactersTest {


    @Mock
    private lateinit var characterService: CharacterService

    private lateinit var getCharacters: GetCharacters

    @Before
    fun setUp() {
        getCharacters = GetCharacters(characterService)
    }

    @Test
    fun invoke() = runBlocking {
        val listCharacters = listOf(
            Character(
                id = 1,
                name = "",
                description = "",
                modified = "",
                thumbnail = Thumbnail("jpg", ""),
                ""
            )
        )
        whenever(characterService.getCharacters()).thenReturn(listCharacters)
        val result = getCharacters.invoke()
        Assert.assertEquals(listCharacters, result)

    }

}
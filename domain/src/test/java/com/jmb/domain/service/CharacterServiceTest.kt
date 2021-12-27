package com.jmb.domain.service

import com.jmb.domain.aggregates.*
import com.jmb.domain.repository.CharacterLocalRepository
import com.jmb.domain.repository.WebSeviceRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharacterServiceTest {
    @Mock
    lateinit var repository: WebSeviceRepository<Character>

    @Mock
    lateinit var localRespository: CharacterLocalRepository

    private lateinit var characterService: CharacterService

    @Before
    fun setUp() {
        characterService = CharacterService(repository, localRespository)
    }

    @Test
    fun getData_success() = runBlocking {
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
        val result = repository.getAll()
        Assert.assertEquals(listCharacters, result)
    }

    @Test
    fun getCharacter_findById_success() = runBlocking {
        val character = Character(
            id = 1,
            name = "",
            description = "",
            modified = "",
            thumbnail = Thumbnail("jpg", ""),
            ""
        )


        whenever(characterService.getCharacter(any())).thenReturn(character)
        val result = localRespository.findById(any())
        Assert.assertEquals(character, result)
    }


}
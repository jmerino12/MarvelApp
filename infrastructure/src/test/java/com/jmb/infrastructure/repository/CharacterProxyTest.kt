package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Character
import com.jmb.domain.aggregates.Thumbnail
import com.jmb.domain.repository.LocalRepository
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharacterProxyTest {


    @Mock
    lateinit var characterRetrofitRepository: CharacterRetrofitRepository

    @Mock
    lateinit var localRepository: LocalRepository<Character>

    @Mock
    lateinit var internetRepository: InternetRepository

    private lateinit var characterProxy: CharacterProxy

    private val character =
        Character(
            id = 1,
            name = "",
            description = "",
            modified = "",
            thumbnail = Thumbnail("jpg", ""),
            ""
        )


    @Before
    fun setUp() {
        characterProxy =
            CharacterProxy(characterRetrofitRepository, localRepository, internetRepository)
    }

    @Test
    fun getCharacters_localDatabase_success() = runBlocking {
        val remoteCharacters = listOf(character)

        whenever(internetRepository.checkConnectionInternet()).thenReturn(true)
        whenever(localRepository.isEmpty()).thenReturn(true)
        whenever(characterRetrofitRepository.getAll()).thenReturn(remoteCharacters)
        characterProxy.getAll()

        verify(localRepository).save(remoteCharacters)
    }

    @Test
    fun getCharacters_remoteWebservice_success() = runBlocking {
        val remoteCharacters = listOf(character)

        whenever(internetRepository.checkConnectionInternet()).thenReturn(true)
        whenever(localRepository.isEmpty()).thenReturn(false)
        whenever(characterRetrofitRepository.getAll()).thenReturn(remoteCharacters)

        val result = characterRetrofitRepository.getAll()

        Assert.assertEquals(remoteCharacters, result)
    }

}
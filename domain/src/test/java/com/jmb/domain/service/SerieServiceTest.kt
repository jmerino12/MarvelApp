package com.jmb.domain.service

import com.jmb.domain.aggregates.*
import com.jmb.domain.repository.WebSeviceRepository
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SerieServiceTest {
    @Mock
    lateinit var repository: WebSeviceRepository<Serie>

    private lateinit var serieSevice: SerieService

    @Before
    fun setUp() {
        serieSevice = SerieService(repository)
    }

    @Test
    fun getData_success() = runBlocking {
        val listSeries = listOf(
            Serie(
                characters = Characters(1, "uri", 0),
                comics = Comics(1, "", 0),
                creators = Creators(1, "", 0),
                description = "",
                endYear = 2000,
                events = Events(1, "", 0),
                id = 1,
                thumbnail = Thumbnail("jpg", ""),
                modified = "",
                previous = "",
                rating = "",
                resourceURI = "",
                startYear = 1999,
                stories = Stories(1, "", 0),
                title = "",
                type = "",
                urls = null
            )
        )

        whenever(serieSevice.getSeries()).thenReturn(listSeries)
        val result = repository.getAll()
        Assert.assertEquals(listSeries, result)
    }
}
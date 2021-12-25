package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Character
import com.jmb.domain.repository.WebSeviceRepository
import com.jmb.infrastructure.anticorruption.toDomain
import com.jmb.infrastructure.server.TheMarvelDb
import javax.inject.Inject

class CharacterRetrofitRepository @Inject constructor(
    private val theMarvelDb: TheMarvelDb,
    private val apiKey: String,
    private val hash: String
) : WebSeviceRepository<Character> {

    override suspend fun getAll(): List<Character> {
        return theMarvelDb.service.listCharacters(apiKey, hash, "1")
            .data.results.map { it.toDomain() }
    }

}

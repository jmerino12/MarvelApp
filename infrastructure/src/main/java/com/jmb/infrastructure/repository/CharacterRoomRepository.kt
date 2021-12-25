package com.jmb.infrastructure.repository

import com.jmb.domain.aggregates.Character
import com.jmb.domain.repository.CharacterLocalRepository
import com.jmb.domain.repository.LocalRepository
import com.jmb.infrastructure.anticorruption.toDomain
import com.jmb.infrastructure.anticorruption.toRoom
import com.jmb.infrastructure.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterRoomRepository @Inject constructor(db: AppDatabase) :
    CharacterLocalRepository, LocalRepository<Character> {
    private val marvelDao = db.marvelDao()


    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { marvelDao.characterCount() <= 0 }

    override suspend fun save(data: List<Character>) = withContext(Dispatchers.IO) {
        marvelDao.insertCharacters(data.map { it.toRoom() })
    }

    override suspend fun getAll(): List<Character> = withContext(Dispatchers.IO) {
        marvelDao.getAllCharactes().map { it.toDomain() }
    }

    override suspend fun findById(id: Int): Character = withContext(Dispatchers.IO) {
        marvelDao.getCharacterById(id).toDomain()
    }


}
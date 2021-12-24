package com.jmb.infrastructure.anticorruption

import com.jmb.infrastructure.dto.Characters as CharactersServer
import com.jmb.domain.aggregates.Characters as CharactersDomain
import com.jmb.infrastructure.dto.Character as CharacterServer
import com.jmb.domain.aggregates.Character as CharacterDomain
import com.jmb.infrastructure.database.entity.Character as CharacterRoom

fun CharactersServer.toDomain(): CharactersDomain = CharactersDomain(
    available, collectionURI, returned
)

fun CharacterServer.toDomain(): CharacterDomain = CharacterDomain(
    id, name, description, modified, thumbnail.toDomain(), resourceURI
)

fun CharacterRoom.toDomain(): CharacterDomain = CharacterDomain(
    id, name, description, modified, thumbnail.toDomain(), resourceURI
)

fun CharacterDomain.toRoom(): CharacterRoom = CharacterRoom(
    id, name, description, modified, resourceURI, thumbnail.toRoom()
)

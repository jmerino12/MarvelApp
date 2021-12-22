package com.jmb.infrastructure.anticorruption

import com.jmb.infrastructure.dto.Characters as CharacterServer
import com.jmb.domain.aggregates.Characters as CharacterDomain

fun CharacterServer.toDomain(): CharacterDomain = CharacterDomain(
    available, collectionURI, returned
)
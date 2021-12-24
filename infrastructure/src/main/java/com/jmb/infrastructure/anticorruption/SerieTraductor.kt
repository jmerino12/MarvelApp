package com.jmb.infrastructure.anticorruption

import com.jmb.infrastructure.dto.Serie as SerieServer
import com.jmb.domain.aggregates.Serie as SerieDomain
import com.jmb.infrastructure.database.entity.Serie as SerieRoom

fun SerieServer.toDomain(): SerieDomain = SerieDomain(
    characters = characters.toDomain(),
    comics = comics.toDomain(),
    creators = creators.toDomain(),
    description = description,
    endYear = endYear,
    events = events.toDomain(),
    id = id,
    modified = modified,
    previous = previous,
    rating = rating,
    resourceURI = resourceURI,
    startYear = startYear,
    stories = stories.toDomain(),
    title = title,
    type = type,
    urls = urls.map { it.toDomain() },
    thumbnail = thumbnail.toDomain()
)

fun SerieDomain.toRoom(): SerieRoom = SerieRoom(
    description,
    endYear,
    id,
    modified,
    previous,
    rating,
    resourceURI,
    startYear,
    title,
    type,
    thumbnail = thumbnail.toRoom()
)

fun SerieRoom.toDomain(): SerieDomain = SerieDomain(
    description = description,
    endYear = endYear,
    id = id,
    modified = modified,
    previous = previous,
    rating = rating,
    resourceURI = resourceURI,
    startYear = startYear,
    title = title,
    type = type,
    urls = null,
    stories = null,
    events = null,
    comics = null,
    characters = null,
    creators = null,
    thumbnail = thumbnail.toDomain()
)
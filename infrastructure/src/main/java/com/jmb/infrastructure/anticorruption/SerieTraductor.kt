package com.jmb.infrastructure.anticorruption

import com.jmb.infrastructure.dto.Serie as SerieServer
import com.jmb.domain.aggregates.Serie as SerieDomain

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
    urls = urls.map { it.toDomain() }
)
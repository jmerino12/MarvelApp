package com.jmb.infrastructure.anticorruption

import com.jmb.infrastructure.dto.Stories as StoriesServer
import com.jmb.domain.aggregates.Stories as StoriesDomain

fun StoriesServer.toDomain(): StoriesDomain = StoriesDomain(
    available, collectionURI, returned
)
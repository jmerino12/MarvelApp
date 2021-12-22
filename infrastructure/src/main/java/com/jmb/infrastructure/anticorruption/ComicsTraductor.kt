package com.jmb.infrastructure.anticorruption

import com.jmb.infrastructure.dto.Comics as ComicsServer
import com.jmb.domain.aggregates.Comics as ComicsDomain

fun ComicsServer.toDomain(): ComicsDomain = ComicsDomain(
    available, collectionURI, returned
)
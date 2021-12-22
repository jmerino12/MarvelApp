package com.jmb.infrastructure.anticorruption

import com.jmb.infrastructure.dto.Events as EventsServer
import com.jmb.domain.aggregates.Events as EventsDomain

fun EventsServer.toDomain(): EventsDomain = EventsDomain(
    available, collectionURI, returned
)
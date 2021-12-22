package com.jmb.infrastructure.anticorruption

import com.jmb.infrastructure.dto.Creators as CreatorsServer
import com.jmb.domain.aggregates.Creators as CreatorsDomain

fun CreatorsServer.toDomain(): CreatorsDomain = CreatorsDomain(
    available, collectionURI, returned
)
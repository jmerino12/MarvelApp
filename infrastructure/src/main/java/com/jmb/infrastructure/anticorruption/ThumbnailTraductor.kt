package com.jmb.infrastructure.anticorruption

import com.jmb.infrastructure.dto.Thumbnail as ThumbnailServer
import com.jmb.domain.aggregates.Thumbnail as ThumbnailDomain

fun ThumbnailServer.toDomain(): ThumbnailDomain = ThumbnailDomain(
    extension, path
)
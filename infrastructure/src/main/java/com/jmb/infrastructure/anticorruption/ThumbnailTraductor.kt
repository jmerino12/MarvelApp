package com.jmb.infrastructure.anticorruption

import com.jmb.infrastructure.dto.Thumbnail as ThumbnailServer
import com.jmb.domain.aggregates.Thumbnail as ThumbnailDomain
import com.jmb.infrastructure.database.entity.Serie.Thumbnail as ThumbnailRoom

fun ThumbnailServer.toDomain(): ThumbnailDomain = ThumbnailDomain(
    extension, path
)

fun ThumbnailDomain.toRoom(): ThumbnailRoom = ThumbnailRoom(
    extension, path
)

fun ThumbnailRoom.toDomain(): ThumbnailDomain = ThumbnailDomain(
    extension, path
)


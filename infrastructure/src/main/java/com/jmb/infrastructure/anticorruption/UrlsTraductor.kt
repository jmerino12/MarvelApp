package com.jmb.infrastructure.anticorruption

import com.jmb.infrastructure.dto.Url as UrlServer
import com.jmb.domain.aggregates.Url as UrlDomain

fun UrlServer.toDomain(): UrlDomain = UrlDomain(
    type, url
)
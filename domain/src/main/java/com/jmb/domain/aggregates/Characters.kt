package com.jmb.domain.aggregates

data class Characters(
    val available: Int,
    val collectionURI: String,
    val returned: Int
)
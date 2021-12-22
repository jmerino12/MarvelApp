package com.jmb.domain.aggregates

data class Events(
    val available: Int,
    val collectionURI: String,
    val returned: Int
)
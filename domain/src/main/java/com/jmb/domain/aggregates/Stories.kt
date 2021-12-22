package com.jmb.domain.aggregates

data class Stories(
    val available: Int,
    val collectionURI: String,
    val returned: Int
)
package com.jmb.domain.aggregates

data class Comics(
    val available: Int,
    val collectionURI: String,
    val returned: Int
)
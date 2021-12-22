package com.jmb.domain.aggregates

data class Serie(
    val characters: Characters,
    val comics: Comics,
    val creators: Creators,
    val description: String?,
    val endYear: Int,
    val events: Events,
    val id: Int,
    val modified: String,
    val previous: String?,
    val rating: String,
    val resourceURI: String,
    val startYear: Int,
    val stories: Stories,
    val title: String,
    val type: String,
    val urls: List<Url>
)
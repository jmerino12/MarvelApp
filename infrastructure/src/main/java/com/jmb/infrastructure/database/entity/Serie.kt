package com.jmb.infrastructure.database.entity

import androidx.room.*


@Entity
data class Serie(
    val description: String?,
    val endYear: Int,
    @PrimaryKey val id: Int,
    val modified: String,
    val previous: String?,
    val rating: String,
    val resourceURI: String,
    val startYear: Int,
    val title: String,
    val type: String,
    @Embedded(prefix = "thumbnail_")
    val thumbnail: Thumbnail
) {
    data class Thumbnail(
        val extension: String,
        val path: String
    )
}

@Entity
data class Character(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val resourceURI: String,
    @Embedded(prefix = "thumbnail_")
    val thumbnail: Serie.Thumbnail
)





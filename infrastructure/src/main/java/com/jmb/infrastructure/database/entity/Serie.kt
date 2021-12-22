package com.jmb.infrastructure.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


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
)

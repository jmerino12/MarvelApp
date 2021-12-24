package com.jmb.infrastructure.dto


import com.google.gson.annotations.SerializedName

data class Serie(
    @SerializedName("characters")
    val characters: Characters,
    @SerializedName("comics")
    val comics: Comics,
    @SerializedName("creators")
    val creators: Creators,
    @SerializedName("description")
    val description: String?,
    @SerializedName("endYear")
    val endYear: Int,
    @SerializedName("events")
    val events: Events,
    @SerializedName("id")
    val id: Int,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("resourceURI")
    val resourceURI: String,
    @SerializedName("startYear")
    val startYear: Int,
    @SerializedName("stories")
    val stories: Stories,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("urls")
    val urls: List<Url>
)
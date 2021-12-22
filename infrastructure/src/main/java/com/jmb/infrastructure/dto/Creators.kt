package com.jmb.infrastructure.dto


import com.google.gson.annotations.SerializedName

data class Creators(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("returned")
    val returned: Int
)
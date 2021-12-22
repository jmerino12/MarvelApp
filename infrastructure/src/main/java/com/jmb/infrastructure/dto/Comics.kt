package com.jmb.infrastructure.dto


import com.google.gson.annotations.SerializedName

data class Comics(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("returned")
    val returned: Int
)
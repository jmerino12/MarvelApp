package com.jmb.infrastructure.dto


import com.google.gson.annotations.SerializedName

data class SerieDbResult(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: Data,
)




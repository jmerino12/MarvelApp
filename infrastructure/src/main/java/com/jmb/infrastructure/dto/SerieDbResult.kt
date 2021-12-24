package com.jmb.infrastructure.dto


import com.google.gson.annotations.SerializedName

data class SerieDbResult<T>(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: Data<T>,
)




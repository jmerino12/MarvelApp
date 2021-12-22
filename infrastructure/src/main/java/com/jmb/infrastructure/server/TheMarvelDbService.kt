package com.jmb.infrastructure.server

import com.jmb.infrastructure.dto.SerieDbResult
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMarvelDbService {
    @GET("series")
    suspend fun listSeries(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") ts: String
    ): SerieDbResult
}

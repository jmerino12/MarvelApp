package com.jmb.usecase.serie

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.service.SerieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetSeries(private val serieService: SerieService) {
    suspend fun invoke(): List<Serie> = withContext(Dispatchers.IO) { serieService.getSeries() }
}
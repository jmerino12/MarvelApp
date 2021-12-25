package com.jmb.usecase.serie

import com.jmb.domain.aggregates.Serie
import com.jmb.domain.service.SerieService

class GetSeries(private val serieService: SerieService) {
    suspend fun invoke(): List<Serie> = serieService.getSeries()
}
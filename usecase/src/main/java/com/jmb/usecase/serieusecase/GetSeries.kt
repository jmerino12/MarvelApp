package com.jmb.usecase.serieusecase

import com.jmb.domain.service.SerieService

class GetSeries(private val serieService: SerieService) {
    suspend fun invoke() = serieService.getSeries()
}
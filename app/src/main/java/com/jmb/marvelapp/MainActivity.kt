package com.jmb.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.jmb.domain.service.SerieService
import com.jmb.infrastructure.repository.SerieRepository
import com.jmb.infrastructure.server.TheMarvelDb
import com.jmb.usecase.serieusecase.GetSeries

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: SerieViewModel by viewModels {
            VMFactory(GetSeries(SerieService(SerieRepository(TheMarvelDb("https://gateway.marvel.com/v1/public/")))))
        }
        model.getSeries()
        setContentView(R.layout.activity_main)
    }
}
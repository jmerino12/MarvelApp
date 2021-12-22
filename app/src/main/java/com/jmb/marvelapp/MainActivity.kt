package com.jmb.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.jmb.domain.service.SerieService
import com.jmb.infrastructure.repository.SerieRepository
import com.jmb.infrastructure.server.TheMarvelDb
import com.jmb.usecase.serieusecase.GetSeries

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model: SerieViewModel by viewModels {
            VMFactory(GetSeries(SerieService(repository = (application as MarvelApp).repository)))
        }
        model.getSeries()
        model.data.observe(this, {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        })
        setContentView(R.layout.activity_main)
    }
}
package com.jmb.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.jmb.domain.service.SerieService
import com.jmb.usecase.serieusecase.GetSeries

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = (application as MarvelApp)
        val model: SerieViewModel by viewModels {
            VMFactory(GetSeries(app.repository))
        }
        model.getSeries()
        model.data.observe(this, {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        })
        setContentView(R.layout.activity_main)
    }
}
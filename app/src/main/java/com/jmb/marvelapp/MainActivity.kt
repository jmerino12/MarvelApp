package com.jmb.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.jmb.domain.service.SerieService
import com.jmb.usecase.serieusecase.GetSeries
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model: SerieViewModel by viewModels()
        model.getSeries()
        model.data.observe(this, {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}
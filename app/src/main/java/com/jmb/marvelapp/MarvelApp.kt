package com.jmb.marvelapp

import android.app.Application
import com.jmb.infrastructure.database.AppDatabase
import com.jmb.infrastructure.repository.SerieRepository
import com.jmb.infrastructure.server.TheMarvelDb

class MarvelApp : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy {
        SerieRepository(
            TheMarvelDb("https://gateway.marvel.com/v1/public/"),
            dao = database.marvelDao()
        )
    }

}
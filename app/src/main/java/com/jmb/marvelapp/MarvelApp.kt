package com.jmb.marvelapp

import android.app.Application
import com.jmb.domain.service.SerieService
import com.jmb.infrastructure.database.AppDatabase
import com.jmb.infrastructure.repository.InternetRepository
import com.jmb.infrastructure.repository.SerieProxy
import com.jmb.infrastructure.repository.SerieRoomRepository
import com.jmb.infrastructure.server.TheMarvelDb
import com.jmb.infrastructure.repository.SerieRetrofitRepository

class MarvelApp : Application() {
    private val database by lazy { AppDatabase.getDatabase(this) }
    private val remoteRepository by lazy { SerieRetrofitRepository(TheMarvelDb("https://gateway.marvel.com/v1/public/")) }
    private val localRepository by lazy { SerieRoomRepository(database) }
    private val androidCheckerPermission by lazy { AndroidCheckedInternet(this) }
    private val internetRepository by lazy { InternetRepository(androidCheckerPermission) }
    val repository by lazy {
        SerieService(
            SerieProxy(
                remoteRepository,
                localRepository,
                internetRepository
            )
        )
    }

}
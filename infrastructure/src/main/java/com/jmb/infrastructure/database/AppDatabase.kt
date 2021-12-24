package com.jmb.infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jmb.infrastructure.database.dao.MarvelDao
import com.jmb.infrastructure.database.entity.Character
import com.jmb.infrastructure.database.entity.Serie

@Database(entities = [Serie::class, Character::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun marvelDao(): MarvelDao
}
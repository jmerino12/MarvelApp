package com.jmb.infrastructure.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jmb.infrastructure.database.entity.Serie
import com.jmb.infrastructure.database.entity.Character

@Dao
interface MarvelDao {
    @Query("SELECT * FROM Serie")
    suspend fun getAll(): List<Serie>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSeries(series: List<Serie>)

    @Query("SELECT * FROM SERIE WHERE id =:id")
    suspend fun getSerieById(id: Int): Serie

    @Query("SELECT COUNT(id) FROM Serie")
    suspend fun serieCount(): Int


    @Query("SELECT * FROM Character")
    suspend fun getAllCharactes(): List<Character>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCharacters(characters: List<Character>)

    @Query("SELECT * FROM Character WHERE id =:id")
    suspend fun getCharacterById(id: Int): Character

    @Query("SELECT COUNT(id) FROM Character")
    suspend fun characterCount(): Int
}
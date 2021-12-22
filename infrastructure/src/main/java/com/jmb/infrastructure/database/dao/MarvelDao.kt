package com.jmb.infrastructure.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jmb.infrastructure.database.entity.Serie

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
}
package com.example.myapplication

import androidx.room.Dao
import androidx.room.Query

@Dao
interface Dao {
    @Query("SELECT * FROM recipe")
    fun getall():List<Recip?>?
}
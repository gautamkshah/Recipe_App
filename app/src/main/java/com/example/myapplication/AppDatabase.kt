package com.example.myapplication

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Recip::class], version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun getDao():Dao
}
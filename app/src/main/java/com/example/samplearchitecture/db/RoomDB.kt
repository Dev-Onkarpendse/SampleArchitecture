package com.example.samplearchitecture.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TempEntity::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {
    abstract fun interfaceDao(): InterfaceDao?
}
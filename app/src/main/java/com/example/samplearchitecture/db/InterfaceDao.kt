package com.example.samplearchitecture.db

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface InterfaceDao {
    @Insert
    fun addTemp(tempEntity: TempEntity)
}
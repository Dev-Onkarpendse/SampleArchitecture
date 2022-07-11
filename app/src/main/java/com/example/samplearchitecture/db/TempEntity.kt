package com.example.samplearchitecture.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "temp_table")
class TempEntity {
    @PrimaryKey(autoGenerate = true)
    var temp_uniqueId: Long = 0L

    var temp_name: String? = null
    var create_timestamp: Long = System.currentTimeMillis()
}

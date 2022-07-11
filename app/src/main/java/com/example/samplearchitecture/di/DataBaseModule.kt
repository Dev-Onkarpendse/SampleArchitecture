package com.example.samplearchitecture.di

import android.app.Application
import androidx.room.Room
import com.example.samplearchitecture.db.InterfaceDao
import com.example.samplearchitecture.db.RoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun providesDataBase(application: Application): RoomDB {
        return Room.databaseBuilder(application!!, RoomDB::class.java, "temp_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun providesInterfaceDao(roomDB: RoomDB): InterfaceDao {
        return roomDB.interfaceDao()!!
    }
}
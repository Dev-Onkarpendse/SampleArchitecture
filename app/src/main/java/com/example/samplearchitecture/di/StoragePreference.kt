package com.example.samplearchitecture.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


interface StoragePreference {
    val sampleData: Flow<String>

    suspend fun setSampleData(string: String)
    suspend fun clearAll()
}

@Singleton
class AppStorePrefs @Inject constructor(@ApplicationContext val context: Context) :
    StoragePreference {

    //private val dataStore: DataStore<Preferences> = context.createDataStore(name = "AppStorePref")
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "AppStorePref")

    private object PreferencesKey {
        val SAMPLE_DATA = stringPreferencesKey("sample_key")
    }

    override val sampleData: Flow<String>
        get() = context.dataStore.data.map { it[PreferencesKey.SAMPLE_DATA]!! }

    override suspend fun setSampleData(string: String) {
        context.dataStore.edit { it[PreferencesKey.SAMPLE_DATA] = string }
    }

    override suspend fun clearAll() {
        context.dataStore.edit { it.clear() }
    }

}
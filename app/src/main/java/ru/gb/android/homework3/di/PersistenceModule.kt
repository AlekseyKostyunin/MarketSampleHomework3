package ru.gb.android.homework3.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides

@Module
object PersistenceModule {

    private val Context.appDataStore: DataStore<Preferences> by preferencesDataStore(name = "app")

    @Provides
    fun provideDataStore(
        context: Context
    ): DataStore<Preferences>{
        return context.appDataStore
    }





}
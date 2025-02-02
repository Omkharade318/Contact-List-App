package com.example.roomdatabase.di

import android.app.Application
import androidx.room.Room
import com.example.roomdatabase.data.Repository
import com.example.roomdatabase.data.database.ContactDatabase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.Provides
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {

    @Singleton
    @Provides
    fun provideDataBase(application: Application): ContactDatabase {
        return Room.databaseBuilder(
            application,
            ContactDatabase::class.java,
            "contact_database.sql"
        )
        .addMigrations(ContactDatabase.MIGRATION_1_2)
        .build()
    }

    @Provides
    @Singleton
    fun provideRepository(database: ContactDatabase): Repository {
        return Repository(database.contactDao())
    }
}
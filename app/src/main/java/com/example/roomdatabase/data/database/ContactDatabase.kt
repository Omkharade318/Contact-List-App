package com.example.roomdatabase.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabase.data.entity.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDatabase: RoomDatabase() { // RoomDatabase is an abstract class that we need to extend by an abstract class
    abstract fun contactDao(): ContactDao

}
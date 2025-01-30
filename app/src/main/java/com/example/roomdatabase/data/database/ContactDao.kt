package com.example.roomdatabase.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.roomdatabase.data.entity.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getAllContacts(): Flow<List<Contact>>
}
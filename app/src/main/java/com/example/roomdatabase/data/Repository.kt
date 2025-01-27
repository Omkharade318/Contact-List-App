package com.example.roomdatabase.data

import com.example.roomdatabase.data.database.ContactDao
import com.example.roomdatabase.data.entity.Contact
import kotlinx.coroutines.flow.onEach

class Repository(
    private val contactDao: ContactDao
) {
    suspend fun insertContact(contact: Contact) = contactDao.insertContact(contact)

    fun updateContact(contact: Contact) = contactDao.updateContact(contact)

    suspend fun deleteContact(contact: Contact) = contactDao.deleteContact(contact)

    fun getAllContacts() = contactDao.getAllContacts().onEach { contacts -> }
}
package com.example.roomdatabase.data

import com.example.roomdatabase.data.database.ContactDao
import com.example.roomdatabase.data.entity.Contact

class Repository(
    private val contactDao: ContactDao
) {
    fun insertContact(contact: Contact) = contactDao.insertContact(contact)

    fun updateContact(contact: Contact) = contactDao.updateContact(contact)

    fun deleteContact(contact: Contact) = contactDao.deleteContact(contact)

    fun getAllContacts() = contactDao.getAllContacts()
}
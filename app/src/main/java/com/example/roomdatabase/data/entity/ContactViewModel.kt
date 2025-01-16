package com.example.roomdatabase.data.entity

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ContactViewModel @Inject constructor(
    val repository: Repository
): ViewModel(){

    private var _state = MutableStateFlow<AppState>(AppState())
    var state = _state.asStateFlow()


    fun insertContact(){
        val contact = Contact(
            name = state.value.name.value,
            phoneNumber = state.value.phoneNumber.value,
            email = state.value.email.value
        )
        repository.insertContact(contact)
    }

}

class AppState(
    var loading : Boolean = false,
    var allContacts: List<Contact> = emptyList<Contact>(),
    var error: String= "",
    var name: MutableState<String> = mutableStateOf(""),
    var phoneNumber: MutableState<String> = mutableStateOf(""),
    var email: MutableState<String> = mutableStateOf(""),
)


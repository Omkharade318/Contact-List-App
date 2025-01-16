package com.example.roomdatabase.data.entity

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


}

class AppState(
    var loading : Boolean = false,
    var allContacts: List<Contact> = emptyList<Contact>(),
    var error: String= ""
)


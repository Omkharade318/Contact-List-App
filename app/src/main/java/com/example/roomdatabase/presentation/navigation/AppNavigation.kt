package com.example.roomdatabase.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabase.data.entity.ContactViewModel
import com.example.roomdatabase.presentation.screens.AddEditScreenUI

@Composable
fun AppNavigation(
    viewModel: ContactViewModel = hiltViewModel()
){

    var navController = rememberNavController()
    val state = viewModel.state.collectAsState()

    NavHost(navController = navController, startDestination = Routes.HomeScreen){
        composable<Routes.HomeScreen>{
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate(Routes.AddEditScreen)
                    }
                ) {
                    Text("Add Contact")
                }
            }
        }

        composable<Routes.AddEditScreen>{
            AddEditScreenUI(
                state = state.value,
                onEvent = {
                    viewModel.insertContact()
                }
            )
        }
    }
}
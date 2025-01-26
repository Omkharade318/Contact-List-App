package com.example.roomdatabase.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roomdatabase.data.entity.ContactViewModel
import com.example.roomdatabase.presentation.screens.AddEditScreenUI
import com.example.roomdatabase.presentation.screens.HomeScreenUI

@Composable
fun AppNavigation(
    viewModel: ContactViewModel = hiltViewModel()
){

    var navController = rememberNavController()
    val state = viewModel.state.collectAsState()

    NavHost(navController = navController, startDestination = Routes.HomeScreen){
        composable<Routes.HomeScreen>{
            HomeScreenUI(
                state = state.value,
                viewModel = viewModel,
                navController = navController
            )
            }

        composable<Routes.AddEditScreen>{
            AddEditScreenUI(
                state = state.value,
                onEvent = {
                    viewModel.insertContact()
                },
                navController = navController
            )
        }
    }
}
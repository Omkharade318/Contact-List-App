package com.example.roomdatabase.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){

    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HomeScreen){
        composable<Routes.HomeScreen>{

        }

        composable<Routes.AddEditScreen>{

        }
    }
}
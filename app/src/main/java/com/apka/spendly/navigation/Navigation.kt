package com.apka.spendly.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apka.spendly.ui.screens.AuthorizationScreen
import com.apka.spendly.ui.screens.DuringLoadingScreen
import com.apka.spendly.ui.screens.GetStartedScreen
import com.apka.spendly.ui.screens.HomeScreen
import com.apka.spendly.ui.screens.SetTokenScreen

@Composable
fun Navigation(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = Screens.GetStartedScreen.name) {
        composable(Screens.DuringLoadingScreen.name) {
            DuringLoadingScreen()
        }
        composable(Screens.GetStartedScreen.name) {
            GetStartedScreen(paddingValues)
        }
        composable(Screens.AuthorizationScreen.name) {
            AuthorizationScreen()
        }
        composable(Screens.SetTokenScreen.name) {
            SetTokenScreen()
        }
        composable(Screens.HomeScreen.name) {
            HomeScreen()
        }
    }
}
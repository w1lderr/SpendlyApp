package com.apka.spendly.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.apka.spendly.ui.screens.Authorization.AuthorizationScreen
import com.apka.spendly.ui.screens.DuringLoading.DuringLoadingScreen
import com.apka.spendly.ui.screens.GetStarted.GetStartedScreen
import com.apka.spendly.ui.screens.HomeScreen.HomeScreen
import com.apka.spendly.ui.screens.SetToken.SetTokenScreen

@Composable
fun Navigation(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = Screens.DuringLoadingScreen.name) {
        composable(Screens.DuringLoadingScreen.name) {
            DuringLoadingScreen(navController, paddingValues)
        }
        composable(Screens.GetStartedScreen.name) {
            GetStartedScreen(navController, paddingValues)
        }
        composable(Screens.AuthorizationScreen.name) {
            AuthorizationScreen(navController, paddingValues)
        }
        composable(Screens.SetTokenScreen.name) {
            SetTokenScreen(navController, paddingValues)
        }
        composable(Screens.HomeScreen.name) {
            HomeScreen(paddingValues)
        }
    }
}
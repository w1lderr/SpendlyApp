package com.apka.spendly.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun SpendlyMainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            val currentDestination =
                navController.currentBackStackEntryAsState().value?.destination?.route

            val showBottomBar = currentDestination in listOf(
                Screens.HomeScreen.name,
                Screens.StatisticsScreen.name,
                Screens.TargetsScreen.name,
                Screens.SettingsScreen.name
            )

            if (showBottomBar) {
                BottomNavigationBar(navController)
            }
        }
    ) { paddingValues ->
        Navigation(navController, paddingValues)
    }
}
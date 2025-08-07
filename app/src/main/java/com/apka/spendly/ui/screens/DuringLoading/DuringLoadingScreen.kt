package com.apka.spendly.ui.screens.DuringLoading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.apka.spendly.navigation.Screens
import org.koin.androidx.compose.koinViewModel

@Composable
fun DuringLoadingScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: DuringLoadingViewModel = koinViewModel()
) {
    val isLoggedIn by viewModel.isLoggedIn.collectAsState(null)

    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn == true) {
            navController.navigate(Screens.HomeScreen.name)
        }

        if (isLoggedIn == false) {
            navController.navigate(Screens.GetStartedScreen.name)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(44.dp),
            color = Color(0xFF723FEB),
            strokeWidth = 4.dp
        )
    }
}
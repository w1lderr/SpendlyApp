package com.apka.spendly.ui.screens.ViewTarget

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.apka.spendly.ui.screens.Target.TargetUiItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun ViewTargetScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    target: TargetUiItem,
    viewModel: ViewTargetViewModel = koinViewModel()
) {

}
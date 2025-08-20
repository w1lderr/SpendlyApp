package com.apka.spendly.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.apka.spendly.ui.screens.AddNewTarget.AddNewTargetScreen
import com.apka.spendly.ui.screens.Authorization.AuthorizationScreen
import com.apka.spendly.ui.screens.BalanceInfo.BalanceInfoScreen
import com.apka.spendly.ui.screens.Challenges.ChallengesScreen
import com.apka.spendly.ui.screens.DuringLoading.DuringLoadingScreen
import com.apka.spendly.ui.screens.ExchangeRate.ExchangeRateScreen
import com.apka.spendly.ui.screens.FinanceTips.FinanceTipsScreen
import com.apka.spendly.ui.screens.GetStarted.GetStartedScreen
import com.apka.spendly.ui.screens.HomeScreen.HomeScreen
import com.apka.spendly.ui.screens.LlamaScreen.LlamaScreen
import com.apka.spendly.ui.screens.Notifications.NotificationsScreen
import com.apka.spendly.ui.screens.SetToken.SetTokenScreen
import com.apka.spendly.ui.screens.Settings.SettingsScreen
import com.apka.spendly.ui.screens.Statistics.StatisticsScreen
import com.apka.spendly.ui.screens.Target.TargetUiItem
import com.apka.spendly.ui.screens.Target.TargetsScreen
import com.apka.spendly.ui.screens.ViewTarget.ViewTargetScreen
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

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
            HomeScreen(navController, paddingValues)
        }
        composable(Screens.ChallengesScreen.name) {
            ChallengesScreen(navController, paddingValues)
        }
        composable(Screens.TargetsScreen.name) {
            TargetsScreen(navController, paddingValues)
        }
        composable(Screens.SettingsScreen.name) {
            SettingsScreen(paddingValues)
        }
        composable(Screens.LLamaScreen.name) {
            LlamaScreen(paddingValues, navController)
        }
        composable(Screens.StatisticsScreen.name) {
            StatisticsScreen(paddingValues)
        }
        composable(Screens.NotificationsScreen.name) {
            NotificationsScreen(paddingValues)
        }
        composable(Screens.AddNewTargetScreen.name) {
            AddNewTargetScreen(navController, paddingValues)
        }
        composable(Screens.FinanceTipsScreen.name) {
            FinanceTipsScreen(navController, paddingValues)
        }
        composable(Screens.ExchangeRateScreen.name) {
            ExchangeRateScreen(paddingValues)
        }
        composable(
            route = "${Screens.BalanceInfoScreen.name}/{balance}/{totalSumSpending}",
            arguments = listOf(
                navArgument("balance") { type = NavType.LongType },
                navArgument("totalSumSpending") { type = NavType.LongType }
            )
        ) {
            val balance = it.arguments?.getLong("balance") ?: 0L
            val totalSumSpending = it.arguments?.getLong("totalSumSpending") ?: 0L

            BalanceInfoScreen(
                paddingValues,
                navController,
                balance,
                totalSumSpending
            )
        }
        composable(
            route = "${Screens.ViewTargetScreen.name}/{targetId}/{uuid}/{targetName}/{targetDescription}/{targetAmount}/{category}/{date}/{completed}/{totalTopUpAmount}/{progressPercent}",
            arguments = listOf(
                navArgument("targetId") { type = NavType.StringType },
                navArgument("uuid") { type = NavType.StringType },
                navArgument("targetName") { type = NavType.StringType },
                navArgument("targetDescription") { type = NavType.StringType },
                navArgument("targetAmount") { type = NavType.LongType },
                navArgument("category") { type = NavType.StringType },
                navArgument("date") { type = NavType.LongType },
                navArgument("completed") { type = NavType.BoolType },
                navArgument("totalTopUpAmount") { type = NavType.LongType },
                navArgument("progressPercent") { type = NavType.IntType }
            )
        ) {
            val targetId = URLDecoder.decode(it.arguments?.getString("targetId") ?: "", StandardCharsets.UTF_8.toString())
            val uuid = URLDecoder.decode(it.arguments?.getString("uuid") ?: "", StandardCharsets.UTF_8.toString())
            val targetName = URLDecoder.decode(it.arguments?.getString("targetName") ?: "", StandardCharsets.UTF_8.toString())
            val targetDescription = URLDecoder.decode(it.arguments?.getString("targetDescription") ?: "", StandardCharsets.UTF_8.toString())
            val targetAmount = it.arguments?.getLong("targetAmount") ?: 0L
            val category = URLDecoder.decode(it.arguments?.getString("category") ?: "", StandardCharsets.UTF_8.toString())
            val date = it.arguments?.getLong("date") ?: 0L
            val completed = it.arguments?.getBoolean("completed") ?: false
            val totalTopUpAmount = it.arguments?.getLong("totalTopUpAmount") ?: 0L
            val progressPercent = it.arguments?.getInt("progressPercent") ?: 0

            ViewTargetScreen(
                paddingValues = paddingValues,
                navController = navController,
                target = TargetUiItem(
                    targetId = targetId,
                    uuid = uuid,
                    targetName = targetName,
                    targetDescription = targetDescription,
                    targetAmount = targetAmount,
                    category = category,
                    date = date,
                    completed = completed,
                    totalTopUpAmount = totalTopUpAmount,
                    progressPercent = progressPercent
                )
            )
        }
    }
}
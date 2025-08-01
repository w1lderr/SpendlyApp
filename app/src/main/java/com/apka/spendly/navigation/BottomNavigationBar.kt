package com.apka.spendly.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.apka.spendly.ui.imageVector.HomeIcon
import com.apka.spendly.ui.imageVector.LlamaIcon
import com.apka.spendly.ui.imageVector.SettingsIcon
import com.apka.spendly.ui.imageVector.StatisticsIcon
import com.apka.spendly.ui.imageVector.TargetIcon

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem(Screens.HomeScreen, HomeIcon),
        BottomNavItem(Screens.StatisticsScreen, StatisticsIcon),
        BottomNavItem(Screens.LLamaScreen, LlamaIcon),
        BottomNavItem(Screens.TargetsScreen, TargetIcon),
        BottomNavItem(Screens.SettingsScreen, SettingsIcon)
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Surface(
        tonalElevation = 1.dp,
        shadowElevation = 1.dp,
        shape = RoundedCornerShape(90.dp),
        color = Color(0xFF1F1F1F),
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 25.dp)
            .fillMaxWidth()
            .height(78.dp),
        border = BorderStroke(1.dp, Color(0xFF313131))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                val selected = item.screen.name == currentRoute
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(
                            if (selected) Color(0xFF806BF6)
                            else Color.Transparent
                        )
                        .clickable {
                            if (!selected) {
                                navController.navigate(item.screen.name) {
                                    popUpTo(Screens.HomeScreen.name) { inclusive = false }
                                    launchSingleTop = true
                                }
                            }
                        }
                ) {
                    Icon(
                        modifier = Modifier.size(27.dp),
                        imageVector = item.icon,
                        contentDescription = item.screen.name,
                        tint = if (selected) Color.White else Color(0xFFB7B7B7)
                    )
                }
            }
        }
    }
}
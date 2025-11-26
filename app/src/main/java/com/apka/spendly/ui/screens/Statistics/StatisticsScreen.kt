package com.apka.spendly.ui.screens.Statistics

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.apka.spendly.navigation.Screens
import org.koin.androidx.compose.koinViewModel
import java.util.Locale

@Composable
fun StatisticsScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: StatisticsViewModel = koinViewModel(),
) {
    val scrollState = rememberScrollState()
    val challengeStat = viewModel.challengeStat.collectAsState()
    val period = viewModel.period.collectAsState()
    val uiState = viewModel.uiState.collectAsState()
    val context = LocalContext.current
    val amount = challengeStat.value.totalSaved / 100

    LaunchedEffect(uiState.value.toast) {
        if (uiState.value.toast.isNotEmpty()) {
            Toast.makeText(context, uiState.value.toast, Toast.LENGTH_SHORT).show()
            viewModel.setToast("")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(paddingValues)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Spacer(modifier = Modifier.height(70.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Всього",
                fontSize = 16.sp,
                color = Color(0xFFB8B8B8),
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(
                            color = Color(0xFF723FEB),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "₴",
                        fontSize = 30.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = if (amount % 1.0 == 0.0) {
                        amount.toInt().toString()
                    } else {
                        String.format(Locale.US, "%.2f", amount)
                    },
                    fontSize = 55.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "заощаджено на челенджах",
                fontSize = 16.sp,
                color = Color(0xFFB8B8B8),
                fontWeight = FontWeight.Normal
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        TabChooser(
            selectedIndex = when (period.value) {
                "week" -> 0
                "month" -> 1
                "year" -> 2
                else -> 0
            },
            onTabSelected = { index ->
                val periodString = when (index) {
                    0 -> "week"
                    1 -> "month"
                    2 -> "year"
                    else -> "week"
                }
                viewModel.setPeriod(periodString)
            }
        )

        Spacer(modifier = Modifier.height(22.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
            ) {
                item {
                    InfoCard(
                        value = challengeStat.value.profitChangePercent,
                        desc = if (challengeStat.value.profitChangePercent > 0) "більше, ніж минулого тижня" else "менше, ніж минулого тижня",
                        showSign = true
                    )
                }

                item {
                    InfoCard(
                        value = (challengeStat.value.avgChallengeProfit / 100).toInt(),
                        desc = "середня економія за день",
                        showSign = true,
                        currency = "₴"
                    )
                }

                item {
                    InfoCard(
                        value = challengeStat.value.finishedChallenges,
                        desc = "завершені челенджі"
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(410.dp)
                    .padding(start = 15.dp, end = 15.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1E1E1E)
                ),
                shape = RoundedCornerShape(25.dp),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.02f))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Challenges",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        Button(
                            modifier = Modifier.size(width = 95.dp, height = 35.dp),
                            onClick = {
                                navController.navigate(Screens.ChallengesScreen.name)
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF723FEB)
                            ),
                            shape = RoundedCornerShape(90.dp)
                        ) {
                            Text(
                                text = "View all",
                                color = Color.White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(35.dp))

                    LazyColumn {
                        itemsIndexed(
                            items = challengeStat.value.challenges.take(4),
                            key = { _, challenge -> challenge.challengeId }
                        ) { index, challenge ->
                            StatChallengeItem(challenge)

                            Spacer(modifier = Modifier.height(25.dp))
                        }
                    }
                }
            }
        }
    }
}
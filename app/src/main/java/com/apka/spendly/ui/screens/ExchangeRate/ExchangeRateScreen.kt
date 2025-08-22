package com.apka.spendly.ui.screens.ExchangeRate

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun ExchangeRateScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: ExchangeRateVM = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(uiState.value.toast) {
        if (uiState.value.toast.isNotEmpty()) {
            Toast.makeText(context, uiState.value.toast, Toast.LENGTH_SHORT).show()
            viewModel.setToast("")
        }
    }

    LaunchedEffect(Unit) {
        viewModel.fetchExchangeRates()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(paddingValues),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(90.dp))
                    .background(Color(0xFF1F1F1F))
                    .border(
                        border = BorderStroke(1.dp, Color(0xFF313131)),
                        shape = RoundedCornerShape(90.dp)
                    )
                    .clickable(
                        onClick = {
                            navController.popBackStack()
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Exchange rate",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "by NBU",
                    color = Color(0xFFB8B8B8),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Box(
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .size(width = 370.dp, height = 50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1F1F1F)
                ),
                shape = RoundedCornerShape(90.dp),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 26.dp, end = 26.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Currency",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFB8B8B8),
                        )

                        Text(
                            text = "Purchase",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFB8B8B8),
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(uiState.value.exchangeRates) { exchangeRate ->
                ExchangeRateItem(exchangeRate)
            }
        }
    }
}
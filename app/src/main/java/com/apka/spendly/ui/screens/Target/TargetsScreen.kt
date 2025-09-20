package com.apka.spendly.ui.screens.Target

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun TargetsScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: TargetViewModel = koinViewModel()
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
        viewModel.fetchTargets()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(paddingValues),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Цілі",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(35.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(uiState.value.targets) { target ->
                TargetItem(
                    targetUiItem = target,
                    onClick = {
                        val encodedName =
                            URLEncoder.encode(target.targetName, StandardCharsets.UTF_8.toString())
                        val encodedDescription = URLEncoder.encode(
                            target.targetDescription ?: "",
                            StandardCharsets.UTF_8.toString()
                        )
                        val encodedCategory =
                            URLEncoder.encode(target.category, StandardCharsets.UTF_8.toString())
                        val encodedTargetId =
                            URLEncoder.encode(target.targetId, StandardCharsets.UTF_8.toString())
                        val encodedUuid =
                            URLEncoder.encode(target.uuid, StandardCharsets.UTF_8.toString())

                        navController.navigate(
                            "${Screens.ViewTargetScreen.name}/${encodedTargetId}/${encodedUuid}/$encodedName/$encodedDescription/${target.targetAmount}/$encodedCategory/${target.date}/${target.completed}/${target.totalTopUpAmount}/${target.progressPercent}"
                        )
                    }
                )
            }

            item {
                Button(
                    modifier = Modifier.size(width = 350.dp, height = 64.dp),
                    onClick = {
                        navController.navigate(Screens.AddNewTargetScreen.name)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1F1F1F)
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        text = "+ Додати нову ціль",
                        fontSize = 19.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
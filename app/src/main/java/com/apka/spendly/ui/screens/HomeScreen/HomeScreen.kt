package com.apka.spendly.ui.screens.HomeScreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
import com.apka.spendly.navigation.Screens
import com.apka.spendly.ui.imageVector.BellIcon
import ir.ehsannarmani.compose_charts.PieChart
import ir.ehsannarmani.compose_charts.models.Pie
import org.koin.androidx.compose.koinViewModel

@SuppressLint("DefaultLocale")
@Composable
fun HomeScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    val greeting = viewModel.greeting.collectAsState("Loading...")
    val balance = viewModel.balance.collectAsState()
    val categories = viewModel.categories.collectAsState()
    val context = LocalContext.current

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
            .padding(paddingValues),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header with greeting and notifications icon
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = greeting.value,
                color = Color.White,
                fontSize = 27.sp,
                fontWeight = FontWeight.Medium
            )

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        border = BorderStroke(1.dp, Color(0xFF313131)),
                        shape = RoundedCornerShape(90.dp)
                    )
                    .clip(RoundedCornerShape(90.dp))
                    .background(Color(0xFF1F1F1F))
                    .clickable(
                        onClick = {
                            navController.navigate(Screens.NotificationsScreen.name)
                        },
                    ),
                contentAlignment = Alignment.Center,

                ) {
                Icon(
                    imageVector = BellIcon,
                    contentDescription = "Notifications",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // Short statistics section
        Box(
            modifier = Modifier
                .size(width = 385.dp, height = 320.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFF1F1F1F))
                .border(
                    border = BorderStroke(1.dp, Color(0xFF313131)),
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(18.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Total Balance",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "₴${balance.value}",
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 45.sp
                        )
                    }

                    // Donut-style pie chart for monthly categories
                    if (categories.value.categories.isNotEmpty()) {
                        PieChart(
                            modifier = Modifier.size(130.dp),
                            data = categories.value.categories.mapIndexed { index, category ->
                                // Convert absolute values to positive for chart display
                                val absoluteTotal = kotlin.math.abs(category.total)
                                Pie(
                                    label = category.category,
                                    data = absoluteTotal.toDouble(),
                                    color = getCategoryColor(index),
                                    selectedColor = getCategoryColor(index).copy(alpha = 0.8f)
                                )
                            },
                            selectedScale = 1.1f,
                            scaleAnimEnterSpec = spring<Float>(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessLow
                            ),
                            colorAnimEnterSpec = tween(300),
                            colorAnimExitSpec = tween(300),
                            scaleAnimExitSpec = tween(300),
                            spaceDegreeAnimExitSpec = tween(300),
                            selectedPaddingDegree = 6f,
                            style = Pie.Style.Stroke(width = 30.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "This month",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(12.dp))

                if (categories.value.categories.isNotEmpty()) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        contentPadding = PaddingValues(horizontal = 4.dp)
                    ) {
                        itemsIndexed(categories.value.categories) { index, category ->
                            CategoryItem(
                                category = category.category,
                                amount = "₴${category.total / 100}",
                                percentage = "${category.percentage}%",
                                color = getCategoryColor(index)
                            )
                        }
                    }
                } else {
                    // Show loading indicator or empty state
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = Color.White
                    )
                }
            }
        }
    }
}

// Helper function to get colors for different categories
private fun getCategoryColor(index: Int): Color {
    val colors = listOf(
        Color(0xFF836EFE),
        Color(0xFF97E0F7),
        Color(0xFFFDFDFD),
        Color(0xFFFFC6C6),
        Color(0xFF7DE2D1)
    )
    return colors[index % colors.size]
}

@Composable
fun CategoryItem(
    category: String,
    amount: String,
    percentage: String,
    color: Color
) {
    Box(
        modifier = Modifier
            .size(width = 110.dp, height = 100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = category,
                color = if (color == Color(0xFFFDFDFD) || color == Color(0xFF97E0F7)) Color.Black else Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = amount,
                color = if (color == Color(0xFFFDFDFD) || color == Color(0xFF97E0F7)) Color.Black else Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )

            Row(
                modifier = Modifier
                    .size(33.dp, 22.dp)
                    .clip(RoundedCornerShape(90.dp))
                    .background(Color.White.copy(alpha = 0.2f)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = percentage,
                    color = if (color == Color(0xFFFDFDFD) || color == Color(0xFF97E0F7)) Color.Black.copy(
                        alpha = 0.7f
                    ) else Color.White.copy(
                        alpha = 0.7f
                    ),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
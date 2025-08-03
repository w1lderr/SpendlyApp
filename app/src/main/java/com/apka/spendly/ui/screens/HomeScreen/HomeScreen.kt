package com.apka.spendly.ui.screens.HomeScreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.apka.spendly.R
import com.apka.spendly.navigation.Screens
import com.apka.spendly.ui.imageVector.BellIcon
import com.apka.spendly.ui.imageVector.FireIcon
import com.apka.spendly.ui.imageVector.IdeaIcon
import com.apka.spendly.ui.imageVector.TargetIcon
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

    var pieData by remember {
        mutableStateOf(
            categories.value.categories.mapIndexed { index, category ->
                val absoluteTotal = kotlin.math.abs(category.total)
                Pie(
                    label = category.category,
                    data = absoluteTotal.toDouble().coerceAtLeast(0.1), // Ensure positive values
                    color = getCategoryColor(index),
                    selectedColor = getCategoryColor(index).copy(alpha = 0.8f)
                )
            }
        )
    }

    LaunchedEffect(categories.value) {
        if (categories.value.categories.isNotEmpty()) {
            pieData = categories.value.categories.mapIndexed { index, category ->
                val absoluteTotal = kotlin.math.abs(category.total)
                Pie(
                    label = category.category,
                    data = absoluteTotal.toDouble().coerceAtLeast(0.1),
                    color = getCategoryColor(index),
                    selectedColor = getCategoryColor(index).copy(alpha = 0.8f)
                )
            }
        }
    }

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

        Spacer(modifier = Modifier.height(23.dp))

        // Short statistics section
        Box(
            modifier = Modifier
                .size(width = 380.dp, height = 320.dp)
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
                            data = pieData,
                            onPieClick = { clickedPie ->
                                println("${clickedPie.label} Clicked")
                                val pieIndex = pieData.indexOf(clickedPie)
                                pieData = pieData.mapIndexed { index, pie ->
                                    pie.copy(selected = index == pieIndex)
                                }
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
                            selectedPaddingDegree = 7f,
                            style = Pie.Style.Stroke(width = 30.dp),
                            spaceDegree = 5f
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "This month",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(13.dp))

                if (categories.value.categories.isNotEmpty()) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
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

        Spacer(modifier = Modifier.height(23.dp))

        // Buttons

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, end = 18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(width = 110.dp, height = 160.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1F1F1F)
                ),
                border = BorderStroke(1.dp, Color(0xFF313131)),
                onClick = {

                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(90.dp))
                            .background(Color(0xFF723FEB)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            imageVector = TargetIcon,
                            contentDescription = null,
                            tint = Color.White,
                        )
                    }

                    Spacer(modifier = Modifier.height(13.dp))

                    Text(
                        text = "Add\n" +
                                "target",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                    )
                }
            }

            Card(
                modifier = Modifier.size(width = 110.dp, height = 160.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1F1F1F)
                ),
                border = BorderStroke(1.dp, Color(0xFF313131)),
                onClick = {

                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(90.dp))
                            .background(Color(0xFF723FEB)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(33.dp),
                            imageVector = FireIcon,
                            contentDescription = null,
                            tint = Color.White,
                        )
                    }

                    Spacer(modifier = Modifier.height(13.dp))

                    Text(
                        text = "View\n" +
                                "Challenges",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                    )
                }
            }

            Card(
                modifier = Modifier.size(width = 110.dp, height = 160.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1F1F1F)
                ),
                border = BorderStroke(1.dp, Color(0xFF313131)),
                onClick = {

                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(90.dp))
                            .background(Color(0xFF723FEB)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(33.dp),
                            imageVector = IdeaIcon,
                            contentDescription = null,
                            tint = Color.White,
                        )
                    }

                    Spacer(modifier = Modifier.height(13.dp))

                    Text(
                        text = "View\n" +
                                "Finance Tips",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(23.dp))

        // Exchange rate section

        Card(
            modifier = Modifier.size(width = 380.dp, 140.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1F1F1F)
            ),
            border = BorderStroke(1.dp, Color(0xFF313131)),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Exchange rate",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                    )

                    Button(
                        modifier = Modifier.size(78.dp, 35.dp),
                        onClick = {

                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF723FEB)
                        )
                    ) {
                        Text(
                            text = "View",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(R.drawable.usa_flag),
                                contentDescription = null
                            )

                            Spacer(modifier = Modifier.width(5.dp))

                            Text(
                                text = "USD",
                                color = Color(0xFFA2A2A2),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Normal
                            )
                        }
                        Text(
                            text = "41.4 / 42.02",
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Column {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(R.drawable.flag_of_europe1),
                                contentDescription = null
                            )

                            Spacer(modifier = Modifier.width(5.dp))

                            Text(
                                text = "EUR",
                                color = Color(0xFFA2A2A2),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Normal
                            )
                        }
                        Text(
                            text = "48.26 / 49.02",
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
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
            .clip(RoundedCornerShape(20.dp))
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
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Row(
                modifier = Modifier
                    .size(33.dp, 22.dp)
                    .clip(RoundedCornerShape(90.dp))
                    .background(
                        if (color == Color(0xFFFDFDFD)) Color.Black.copy(
                            alpha = 0.2f
                        ) else Color.White.copy(
                            alpha = 0.2f
                        ),
                    ),
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
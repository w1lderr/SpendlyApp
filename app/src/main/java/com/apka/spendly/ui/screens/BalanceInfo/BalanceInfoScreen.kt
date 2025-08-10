package com.apka.spendly.ui.screens.BalanceInfo

import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.apka.spendly.data.dto.TransactionDTO
import com.apka.spendly.ui.imageVector.ExitIcon
import org.koin.androidx.compose.koinViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun BalanceInfoScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    balance: Long,
    totalSumSpending: Long,
    viewModel: BalanceInfoVM = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    val currentMonth = SimpleDateFormat("MMMM", Locale.getDefault())
        .format(Calendar.getInstance().time)
    val context = LocalContext.current

    LaunchedEffect(uiState.value.toast) {
        if (uiState.value.toast.isNotEmpty()) {
            Toast.makeText(context, uiState.value.toast, Toast.LENGTH_SHORT).show()
            viewModel.setToast("")
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getTransactions()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(paddingValues),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(
                        bottomStart = 30.dp,
                        bottomEnd = 30.dp
                    )
                )
                .clip(
                    RoundedCornerShape(
                        bottomStart = 30.dp,
                        bottomEnd = 30.dp
                    )
                )
                .background(Color(0xFF1F1F1F))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp, top = 20.dp, end = 25.dp, bottom = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                ) {
                    Column(
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Text(
                            text = "My Balance",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "₴${balance}",
                            color = Color.White,
                            fontSize = 50.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(90.dp))
                            .background(Color(0xFF242424))
                            .clickable(
                                onClick = {
                                    navController.popBackStack()
                                }
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            imageVector = ExitIcon,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Spending ",
                            color = Color.White,
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Normal
                        )

                        Text(
                            text = currentMonth,
                            color = Color(0xFF908F92),
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Normal,
                        )
                    }

                    Text(
                        text = "${totalSumSpending / 100}₴",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF908F92)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "This ",
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = "month",
                color = Color(0xFF908F92),
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal,
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        LazyColumn {
            items(uiState.value.transactions) { transaction ->
                TransactionItem(transaction)
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Composable
fun TransactionItem(
    transactionDTO: TransactionDTO
) {
    val calendar = Calendar.getInstance().apply {
        timeInMillis = transactionDTO.date
    }

    val timeFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
    val dateFormat = SimpleDateFormat("MMMM d", Locale.getDefault())

    val time = timeFormat.format(calendar.time)
    val date = dateFormat.format(calendar.time)
    val year = calendar.get(Calendar.YEAR)

    Row(
        modifier = Modifier.size(360.dp, 55.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = transactionDTO.description,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(3.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$time - ",
                    color = Color(0xFF908F92),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )

                Text(
                    text = "$date ",
                    color = Color(0xFF908F92),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )

                Text(
                    text = "$year",
                    color = Color(0xFF908F92),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }

        Text(
            text = "${transactionDTO.amount / 100}₴",
            color = Color(0xFFBEBEBE),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}
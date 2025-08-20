package com.apka.spendly.ui.screens.TopUpHistory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apka.spendly.data.dto.TargetTopUpHistoryDTO
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun TopUpHistoryItem(topUpHistoryDTO: TargetTopUpHistoryDTO) {
    val calendar = Calendar.getInstance().apply {
        timeInMillis = topUpHistoryDTO.timestamp
    }

    val dateFormat = SimpleDateFormat("MMMM d", Locale.getDefault())
    val date = dateFormat.format(calendar.time)
    val year = calendar.get(Calendar.YEAR)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$date $year",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = "${topUpHistoryDTO.amount / 100}₴",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
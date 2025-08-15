package com.apka.spendly.ui.screens.Statistics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apka.spendly.data.dto.UserChallengeDTO
import com.apka.spendly.ui.imageVector.TargetIcon

@Composable
fun StatChallengeItem(userChallengeDTO: UserChallengeDTO) {
    val statusColor = when(userChallengeDTO.status) {
        "started" -> Color(0xFFFFE75F)
        "completed" -> Color(0xFF3DA86F)
        "failed" -> Color(0xFFDE241B)
        else -> Color(0xFF723FEB)
    }

    val statusName = when(userChallengeDTO.status) {
        "started" -> "Started"
        "completed" -> "Completed"
        "failed" -> "Failed"
        else -> "Started"
    }

    val statusTextColor = when(userChallengeDTO.status) {
        "started" -> Color.Black
        "completed" -> Color.White
        "failed" -> Color.White
        else -> Color.White
    }

    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(55.dp)
                    .border(
                        border = BorderStroke(1.dp, Color(0xFF313131)),
                        shape = RoundedCornerShape(90.dp)
                    )
                    .clip(RoundedCornerShape(90.dp))
                    .background(Color(0xFF1F1F1F)),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = TargetIcon,
                    contentDescription = null,
                    tint = Color(0xFFB7B7B7)
                )
            }

            Spacer(modifier = Modifier.width(13.dp))

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = userChallengeDTO.challengeName,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(5.dp))

                Box(
                    modifier = Modifier
                        .size(width = 80.dp, height = 25.dp)
                        .clip(RoundedCornerShape(90.dp))
                        .background(statusColor),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = statusName,
                        color = statusTextColor,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Text(
            text = "+${userChallengeDTO.totalSaved / 100} ₴",
            color = Color.White,
            fontSize = 17.sp,
            fontWeight = FontWeight.Normal
        )
    }
}
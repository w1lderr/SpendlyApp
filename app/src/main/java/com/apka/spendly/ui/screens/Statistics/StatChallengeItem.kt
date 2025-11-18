package com.apka.spendly.ui.screens.Statistics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apka.spendly.data.dto.UserChallengeDTO
import com.apka.spendly.ui.imageVector.TargetIcon
import java.util.Locale

@Composable
fun StatChallengeItem(challenge: UserChallengeDTO) {
    val value = challenge.totalSaved / 100

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = Color(0xFF1F1F1F),
                            shape = RoundedCornerShape(360.dp)
                        )
                        .border(
                            border = BorderStroke(1.dp, Color.White.copy(alpha = 0.05f)),
                            shape = RoundedCornerShape(360.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        imageVector = TargetIcon,
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = challenge.challengeName,
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Box(
                        modifier = Modifier
                            .size(width = 70.dp, height = 25.dp)
                            .background(
                                color = when (challenge.status) {
                                    "completed" -> Color(0xFF42B377)
                                    "failed" -> Color(0xFFDE241B)
                                    "started" -> Color(0xFFFFCA3F)
                                    else -> Color(0xFFFFCA3F)
                                },
                                shape = RoundedCornerShape(90.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = when (challenge.status) {
                                "completed" -> "Завершено"
                                "failed" -> "Провалено"
                                "started" -> "Почато"
                                else -> "Почато"
                            },
                            color = when (challenge.status) {
                                "started" -> Color.Black
                                else -> Color.White
                            },
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            Text(
                text = "${String.format(Locale.US, "%.2f", value)}₴",
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}
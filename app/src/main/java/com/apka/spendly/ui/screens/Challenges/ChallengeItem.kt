package com.apka.spendly.ui.screens.Challenges

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

@Composable
fun ChallengeItem(
    challengeItemUI: ChallengeItemUI,
    onJoin: () -> Unit
) {
    val cardHeight = when (challengeItemUI.status) {
        "not started" -> 190.dp
        "started" -> 230.dp
        "completed" -> 230.dp
        "failed" -> 230.dp
        else -> 200.dp
    }

    Card(
        modifier = Modifier.size(width = 380.dp, height = cardHeight),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1F1F1F)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            // Title
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "\uD83D\uDD25",
                    fontSize = 23.sp
                )

                Spacer(modifier = Modifier.width(13.dp))

                Text(
                    text = challengeItemUI.name,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Description
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "\uD83C\uDFAF",
                    fontSize = 23.sp
                )

                Spacer(modifier = Modifier.width(13.dp))

                Text(
                    text = challengeItemUI.description,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            if (challengeItemUI.status == "started" || challengeItemUI.status == "completed" || challengeItemUI.status == "failed") {
                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "\uD83D\uDCC5",
                        fontSize = 23.sp
                    )

                    Spacer(modifier = Modifier.width(13.dp))

                    Text(
                        text = "${challengeItemUI.daysCompleted}/${challengeItemUI.daysRequired}",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            if (challengeItemUI.status == "not started") {
                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Not Started",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Button(
                        modifier = Modifier.size(width = 100.dp, height = 40.dp),
                        onClick = {
                            onJoin()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF723FEB)
                        ),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "Join",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            if (challengeItemUI.status == "started") {
                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "\uD83D\uDCB0",
                            fontSize = 23.sp
                        )

                        Spacer(modifier = Modifier.width(13.dp))

                        Text(
                            text = "Saved +${(challengeItemUI.totalSaved / 100).toInt()}₴",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Button(
                        modifier = Modifier.size(width = 110.dp, height = 40.dp),
                        onClick = {

                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFE75F)
                        ),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "Started",
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            if (challengeItemUI.status == "completed") {
                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "\uD83D\uDCB0",
                            fontSize = 23.sp
                        )

                        Spacer(modifier = Modifier.width(13.dp))

                        Text(
                            text = "Total Saved +${(challengeItemUI.totalSaved / 100).toInt()}₴",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Button(
                        modifier = Modifier.size(width = 116.dp, height = 40.dp),
                        onClick = {

                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF3DA86F)
                        ),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "Finished",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            if (challengeItemUI.status == "failed") {
                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "\uD83D\uDCB0",
                            fontSize = 23.sp
                        )

                        Spacer(modifier = Modifier.width(13.dp))

                        Text(
                            text = "Total Saved +${(challengeItemUI.totalSaved / 100).toInt()}₴",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Button(
                        modifier = Modifier.size(width = 100.dp, height = 40.dp),
                        onClick = {

                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFDE241B)
                        ),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "Failed",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}
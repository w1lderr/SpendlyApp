package com.apka.spendly.ui.screens.LlamaScreen

import android.widget.Toast
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.apka.spendly.data.dto.MessageDTO
import com.apka.spendly.ui.imageVector.ArrowUpIcon
import com.apka.spendly.ui.imageVector.MicrophoneIcon
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LlamaScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: LlamaViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val uiState = viewModel.uiState.collectAsState()
    val message = viewModel.message.collectAsState()

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
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(90.dp))
                    .background(Color(0xFF1F1F1F))
                    .clickable(
                        onClick = {
                            navController.popBackStack()
                        }
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Box(
                modifier = Modifier
                    .size(width = 110.dp, height = 35.dp)
                    .clip(RoundedCornerShape(90.dp))
                    .background(Color(0xFF0064E0)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Llama 3",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(90.dp))
                    .background(Color(0xFF1F1F1F))
                    .clickable(
                        onClick = {
                            viewModel.deleteMessages()
                        }
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        if (uiState.value.messages.isNotEmpty()) {
            Spacer(modifier = Modifier.height(30.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                reverseLayout = true,
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                items(uiState.value.messages.reversed()) { msg ->
                    MessageItem(msg)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
        } else {
            Spacer(modifier = Modifier.height(105.dp))

            DonutGradientRing()

            Spacer(modifier = Modifier.weight(1f))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                itemsIndexed(
                    listOf(
                        "How can I save more money each month?",
                        "Can you help me create a savings plan?",
                        "How can I avoid impulse purchases?",
                        "How can I stick to my budget when shopping?",
                        "What's the best way to save for a vacation?",
                    )
                ) { index, question ->
                    QuestionItem(
                        question = question,
                        viewModel = viewModel
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Box(
                modifier = Modifier
                    .size(400.dp, 80.dp)
                    .clip(RoundedCornerShape(90.dp))
                    .background(Color(0xFF1F1F1F))
                    .padding(start = 6.dp, end = 18.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        modifier = Modifier.width(270.dp),
                        singleLine = true,
                        value = message.value,
                        onValueChange = {
                            viewModel.onMessageChange(it)
                        },
                        placeholder = {
                            Text(
                                text = "Ask Meta AI...",
                                color = Color(0xFFB8B8B8),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal
                            )
                        },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            cursorColor = Color.White,
                            focusedPlaceholderColor = Color.White,
                            unfocusedPlaceholderColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        )
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = MicrophoneIcon,
                            contentDescription = null,
                            tint = Color.White
                        )

                        Spacer(modifier = Modifier.width(25.dp))

                        Button(
                            modifier = Modifier.size(60.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF0064E0)
                            ),
                            shape = RoundedCornerShape(90.dp),
                            onClick = {
                                viewModel.sendMessage()
                            },
                            enabled = message.value.isNotEmpty()
                        ) {
                            Icon(
                                modifier = Modifier.size(50.dp),
                                imageVector = ArrowUpIcon,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MessageItem(
    messageDTO: MessageDTO
) {
    Card(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (messageDTO.sender == "user") {
                Color(0xFF0064E0)
            } else {
                Color(0xFF323338)
            }
        )
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = messageDTO.content,
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun DonutGradientRing(
    size: Dp = 175.dp,
    thickness: Dp = 32.dp,
    colors: List<Color> = listOf(
        Color(0xFF6247FB),
        Color(0xFFD45FF8),
        Color(0xFF4C62F1),
        Color(0xFF10AED1),
        Color(0xFF3953FF)
    ), // tweak to your purple→blue gradient
    startAngleOffset: Float = 180f // rotate so the seam is at bottom
) {
    Canvas(modifier = Modifier.size(size)) {
        // 1. configure stroke
        val stroke = Stroke(
            width = thickness.toPx(),
            cap = StrokeCap.Round
        )
        // 2. build a sweep gradient centered in the Canvas
        val sweep = Brush.sweepGradient(
            colors = colors,
            center = center
        )
        // 3. draw a full 360° arc
        drawArc(
            brush = sweep,
            startAngle = startAngleOffset - 90f, // -90 so 0° is at top, +180 to move seam to bottom
            sweepAngle = 360f,
            useCenter = false,
            style = stroke
        )
    }
}

@Composable
fun QuestionItem(
    question: String,
    viewModel: LlamaViewModel
) {
    Card(
        modifier = Modifier.size(width = 200.dp, height = 90.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1F1F1F)
        ),
        onClick = {
            viewModel.onMessageChange(question)
            viewModel.sendMessage()
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = question,
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}
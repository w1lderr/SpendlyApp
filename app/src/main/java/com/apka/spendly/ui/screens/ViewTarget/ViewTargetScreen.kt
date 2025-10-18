package com.apka.spendly.ui.screens.ViewTarget

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.apka.spendly.navigation.Screens
import com.apka.spendly.ui.imageVector.BrokenImageIcon
import com.apka.spendly.ui.screens.AddNewTarget.Categories
import com.apka.spendly.ui.screens.Target.TargetUiItem
import org.koin.androidx.compose.koinViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ViewTargetScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    target: TargetUiItem,
    viewModel: ViewTargetViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    val contribution = viewModel.contribution.collectAsState()
    val context = LocalContext.current
    val category = Categories.fromTitle(target.category)

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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 8.dp),
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

            LinearProgressIndicator(
                modifier = Modifier
                    .size(width = 200.dp, height = 12.dp)
                    .clip(RoundedCornerShape(90.dp)),
                color = if (target.totalTopUpAmount == target.targetAmount) {
                    Color(0xFF3DA86F)
                } else {
                    Color(0xFF723FEB)
                },
                progress = target.progressPercent.toFloat() / 100f,
            )

            Box(
                modifier = Modifier.size(50.dp)
            )
        }

        if (target.totalTopUpAmount == target.targetAmount) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Вітання!",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(40.dp))
        } else {
            Spacer(modifier = Modifier.height(100.dp))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(200.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (target.totalTopUpAmount == target.targetAmount) {
                        Color(0xFF3DA86F)
                    } else {
                        Color(0xFF723FEB)
                    }
                ),
                shape = CircleShape
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier.size(90.dp),
                        imageVector = category?.icon ?: BrokenImageIcon,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = target.targetName,
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        if (!target.targetDescription.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = target.targetDescription,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFB8B8B8),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "₴${target.totalTopUpAmount / 100} of ₴${target.targetAmount / 100}",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(25.dp))

        if (target.totalTopUpAmount == target.targetAmount) {
            Button(
                modifier = Modifier.size(width = 245.dp, height = 60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3DA86F)
                ),
                shape = RoundedCornerShape(90.dp),
                onClick = {

                }
            ) {
                Text(
                    text = "Завершено",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
        } else {
            Button(
                modifier = Modifier.size(width = 245.dp, height = 60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF723FEB)
                ),
                shape = RoundedCornerShape(90.dp),
                onClick = {
                    viewModel.setShowAlertDialogState(true)
                }
            ) {
                Text(
                    text = "Додати внесок",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Card(
            modifier = Modifier
                .padding(bottom = 25.dp)
                .size(width = 380.dp, height = 80.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1F1F1F)
            ),
            shape = RoundedCornerShape(90.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Історія поповнень",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )

                    Button(
                        modifier = Modifier.size(width = 100.dp, height = 42.dp),
                        onClick = {
                            val encodeTargetId = URLEncoder.encode(
                                target.targetId,
                                StandardCharsets.UTF_8.toString()
                            )
                            val route = "${Screens.TopUpHistoryScreen.name}/${encodeTargetId}"
                            navController.navigate(route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (target.totalTopUpAmount == target.targetAmount) {
                                Color(0xFF3DA86F)
                            } else {
                                Color(0xFF723FEB)
                            }
                        ),
                        shape = RoundedCornerShape(90.dp)
                    ) {
                        Text(
                            text = "Глянути",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }

    if (uiState.value.showAlertDialog) {
        ShowAlertDialog(
            viewModel = viewModel,
            targetId = target.targetId,
            contribution = contribution.value
        )
    }
}

@Composable
fun ShowAlertDialog(
    viewModel: ViewTargetViewModel,
    targetId: String,
    contribution: String,
) {
    AlertDialog(
        onDismissRequest = {
            viewModel.setShowAlertDialogState(false)
        },
        title = {
            Text(
                text = "Додати внесок",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        },
        containerColor = Color(0xFF1A1A1A),
        text = {
            TextField(
                value = contribution,
                onValueChange = { viewModel.onContributionChanged(it) },
                label = {
                    Text(
                        text = "Сума у грн",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF1F1F1F),
                    unfocusedContainerColor = Color(0xFF1F1F1F),
                    cursorColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLabelColor = Color(0xFFB8B8B8),
                    unfocusedLabelColor = Color(0xFFB8B8B8)
                )
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (contribution.isNotEmpty() && contribution.toLongOrNull() != null) {
                        viewModel.addContribution(targetId)
                        viewModel.onContributionChanged("")
                    } else {
                        viewModel.setToast("Введіть дійсну суму")
                    }
                }
            ) {
                Text(
                    text = "Додати",
                    color = Color.White
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    viewModel.setShowAlertDialogState(false)
                }
            ) {
                Text(
                    text = "Скасувати",
                    color = Color.White
                )
            }
        }
    )
}
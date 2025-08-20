package com.apka.spendly.ui.screens.AddNewTarget

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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.apka.spendly.ui.imageVector.DescriptionIcon
import com.apka.spendly.ui.imageVector.MoneyIcon
import com.apka.spendly.ui.imageVector.NotificationFilled
import com.apka.spendly.ui.imageVector.NotificationIconNotFilled
import com.apka.spendly.ui.imageVector.TargetIcon
import org.koin.androidx.compose.koinViewModel

@Composable
fun AddNewTargetScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: AddNewTargetViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    val target = viewModel.target.collectAsState()
    val context = LocalContext.current
    val categoriesList = Categories.entries.toList()
    var selectedCategory by remember { mutableStateOf<Categories?>(null) }

    LaunchedEffect(uiState.value.toast) {
        if (uiState.value.toast.isNotEmpty()) {
            Toast.makeText(context, uiState.value.toast, Toast.LENGTH_SHORT).show()
            viewModel.setToast("")
        }
    }

    LaunchedEffect(uiState.value.isNavigate) {
        if (uiState.value.isNavigate) {
            navController.popBackStack()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A1A1A))
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
        )
        {
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

            Text(
                text = "Add new target",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium
            )

            Box(
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(width = 380.dp, height = 80.dp),
                shape = RoundedCornerShape(13.dp),
                colors = androidx.compose.material3.CardDefaults.cardColors(
                    containerColor = Color(0xFF1F1F1F)
                ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(33.dp),
                            imageVector = TargetIcon,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    TextField(
                        value = target.value.targetName,
                        onValueChange = { viewModel.onNameChanged(it) },
                        label = {
                            Text(
                                text = "Name",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Normal
                            )
                        },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFF1F1F1F),
                            unfocusedContainerColor = Color(0xFF1F1F1F),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedLabelColor = Color(0xFFB8B8B8),
                            unfocusedLabelColor = Color(0xFFB8B8B8)
                        )
                    )


                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(width = 380.dp, height = 80.dp),
                shape = RoundedCornerShape(13.dp),
                colors = androidx.compose.material3.CardDefaults.cardColors(
                    containerColor = Color(0xFF1F1F1F)
                ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(31.dp),
                            imageVector = DescriptionIcon,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    TextField(
                        value = target.value.targetDescription,
                        onValueChange = { viewModel.onDescriptionChanged(it) },
                        label = {
                            Text(
                                text = "Description (optional)",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Normal
                            )
                        },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFF1F1F1F),
                            unfocusedContainerColor = Color(0xFF1F1F1F),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedLabelColor = Color(0xFFB8B8B8),
                            unfocusedLabelColor = Color(0xFFB8B8B8)
                        )
                    )


                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(width = 380.dp, height = 80.dp),
                shape = RoundedCornerShape(13.dp),
                colors = androidx.compose.material3.CardDefaults.cardColors(
                    containerColor = Color(0xFF1F1F1F)
                ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(35.dp),
                            imageVector = MoneyIcon,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    TextField(
                        value = target.value.targetAmount,
                        onValueChange = { viewModel.onAmountChanged(it) },
                        label = {
                            Text(
                                text = "Amount",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Normal
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Number
                        ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFF1F1F1F),
                            unfocusedContainerColor = Color(0xFF1F1F1F),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = Color.White,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedLabelColor = Color(0xFFB8B8B8),
                            unfocusedLabelColor = Color(0xFFB8B8B8)
                        )
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
                text = "Select category",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(categoriesList) { category ->
                val isSelected = category == selectedCategory
                CategoryItem(
                    category = category,
                    isSelected = isSelected,
                    onClick = {
                        viewModel.onCategoryChanged(category.title)
                        selectedCategory = category
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (target.value.enabledReminder) {
                    Icon(
                        modifier = Modifier.size(width = 33.dp, height = 40.dp),
                        imageVector = NotificationFilled,
                        contentDescription = null,
                        tint = Color.White,
                    )
                } else {
                    Icon(
                        modifier = Modifier.size(width = 33.dp, height = 40.dp),
                        imageVector = NotificationIconNotFilled,
                        contentDescription = null,
                        tint = Color.White,
                    )
                }

                Spacer(modifier = Modifier.width(18.dp))

                Text(
                    text = "Enable reminder",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Switch(
                checked = target.value.enabledReminder,
                onCheckedChange = {
                    viewModel.onReminderChanged(it)
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF723FEB),
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color(0xFF313131)
                )
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier.size(width = 370.dp, height = 70.dp),
                onClick = {
                    viewModel.addTarget()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF723FEB)
                )
            ) {
                Text(
                    text = "Save Target",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }
    }
}
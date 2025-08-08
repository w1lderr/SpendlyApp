package com.apka.spendly.ui.screens.SetToken

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apka.spendly.navigation.Screens
import org.koin.androidx.compose.koinViewModel

@Composable
fun SetTokenScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: SetTokenViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    val token = viewModel.token.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(uiState.value.toast) {
        if (uiState.value.toast.isNotEmpty()) {
            Toast.makeText(context, uiState.value.toast, Toast.LENGTH_SHORT).show()
            viewModel.setToast("")
        }
    }

    LaunchedEffect(uiState.value.navigateToHome) {
        if (uiState.value.navigateToHome) {
            navController.navigate(Screens.HomeScreen.name)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = token.value,
            onValueChange = { viewModel.setToken(it) },
            label = {
                Text("Token")
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF723FEB),
                unfocusedBorderColor = Color(0xFF723FEB),
                focusedLabelColor = Color(0xFF723FEB),
                cursorColor = Color.LightGray
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier.size(width = 170.dp, height = 48.dp),
            onClick = {
                viewModel.setFcmToken()
                viewModel.sendTokenRequest()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF723FEB)
            ),
        ) {
            Text(
                text = "Set Token",
                fontSize = 15.sp
            )
        }
    }
}

@Preview
@Composable
fun SetTokenScreenPreview() {
    val navController = rememberNavController()
    val paddingValues = PaddingValues()
    SetTokenScreen(navController, paddingValues)
}
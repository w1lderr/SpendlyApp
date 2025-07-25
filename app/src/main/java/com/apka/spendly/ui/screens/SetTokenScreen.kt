package com.apka.spendly.ui.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apka.spendly.navigation.Screens

@Composable
fun SetTokenScreen(
    navController: NavController,
    paddingValues: PaddingValues
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color(0xFF1A1A1A)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {

            },
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
                navController.navigate(Screens.HomeScreen.name)
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
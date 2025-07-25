package com.apka.spendly.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apka.spendly.R
import com.apka.spendly.navigation.Screens

@Composable
fun GetStartedScreen(
    navController: NavController,
    paddingValues: PaddingValues
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Image(
            modifier = Modifier.size(height = 257.dp, width = 324.dp),
            painter = painterResource(id = R.drawable.human_with_laptop),
            contentDescription = "",
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Take Control of\n" +
                        "Your Finances",
                color = Color.White,
                fontSize = 45.sp,
                lineHeight = 48.sp,
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "Welcome to your finance app! Track\n" +
                        "spending, save smart, and reach\n" +
                        "your finance goals.",
                color = Color(0xFFB5B5B5),
                fontSize = 18.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Normal
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            modifier = Modifier.size(width = 310.dp, height = 80.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF723FEB)
            ),
            onClick = {
                navController.navigate(Screens.AuthorizationScreen.name)
            }
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = "Get Started",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Arrow Right",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun GetStartedScreenPreview() {
    val navController = rememberNavController()
    val paddingValues = PaddingValues()
    GetStartedScreen(navController, paddingValues)
}
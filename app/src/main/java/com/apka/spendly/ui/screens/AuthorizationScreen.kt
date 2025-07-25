package com.apka.spendly.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun AuthorizationScreen(
    navController: NavController,
    paddingValues: PaddingValues
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Column (
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Authorization",
                fontSize = 38.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Choose a bank for authorization",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFFB5B5B5)
            )
        }

        Spacer(modifier = Modifier.height(70.dp))

        Column(
            modifier = Modifier.fillMaxWidth().padding(30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Supported banks",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(25.dp))

            LazyColumn {
                item {
                    BankItem(navController)
                }
            }
        }
    }
}

@Composable
fun BankItem(
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(90.dp))
            .clickable {
                navController.navigate(Screens.SetTokenScreen.name)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1F1F1F)
        ),
        shape = RoundedCornerShape(90.dp),

    ) {
        Row (
            modifier = Modifier.fillMaxSize().padding(start = 25.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = painterResource(R.drawable.monobank_logo),
                contentDescription = "",
            )

            Spacer(modifier = Modifier.width(13.dp))

            Text(
                text = "Monobank",
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun AuthorizationScreenPreview() {
    val navController = rememberNavController()
    val paddingValues = PaddingValues()
    AuthorizationScreen(navController, paddingValues)
}
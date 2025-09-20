package com.apka.spendly.ui.screens.SetToken

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.withStyle
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
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 8.dp),
            horizontalArrangement = Arrangement.Start,
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
                        }), contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(300.dp))

        OutlinedTextField(
            modifier = Modifier
                .width(300.dp)
                .height(66.dp),
            value = token.value,
            onValueChange = { viewModel.setToken(it) },
            label = {
                Text("Монобанк API Токен")
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
            ),
            shape = RoundedCornerShape(15.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 55.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = uiState.value.isTermsOfUseAgreed,
                onCheckedChange = {
                    viewModel.setIsTermsOfUseAgreed(it)
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF723FEB),
                    uncheckedColor = Color.White,
                    checkmarkColor = Color.White
                )
            )

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val annotatedText = buildAnnotatedString {
                    append("Я погоджуюсь з ")

                    pushStringAnnotation(tag = "terms", annotation = "terms_of_use")
                    withStyle(style = SpanStyle(color = Color(0xFF723FEB))) {
                        append("умовами використання")
                    }
                    pop()

                    append(" та ")

                    pushStringAnnotation(tag = "privacypolicy", annotation = "privacy_policy")
                    withStyle(style = SpanStyle(color = Color(0xFF723FEB))) {
                        append("політикою конфіденційності")
                    }
                    pop()
                }

                ClickableText(
                    text = annotatedText,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    onClick = { offset ->
                        annotatedText.getStringAnnotations(
                            tag = "terms",
                            start = offset,
                            end = offset
                        ).firstOrNull()?.let {
                            navController.navigate(Screens.TermsOfUseScreen.name)
                        }

                        annotatedText.getStringAnnotations(
                            tag = "privacypolicy",
                            start = offset,
                            end = offset
                        ).firstOrNull()?.let {
                            navController.navigate(Screens.PrivacyPolicyScreen.name)
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            enabled = uiState.value.isTermsOfUseAgreed,
            modifier = Modifier.size(width = 270.dp, height = 60.dp),
            onClick = {
                viewModel.sendTokenRequest()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF723FEB)
            ),
        ) {
            Text(
                text = "Встановити токен",
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold
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
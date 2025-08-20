package com.apka.spendly.ui.screens.AddNewTarget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryItem(
    category: Categories,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Text(
        text = category.title,
        color = Color.White,
        fontSize = 15.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .background(
                color = if (isSelected) Color(0xFF723FEB) else Color(0xFF1F1F1F),
                shape = RoundedCornerShape(90.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 22.dp, vertical = 12.dp)
    )
}
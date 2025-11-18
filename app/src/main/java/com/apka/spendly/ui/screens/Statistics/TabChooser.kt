package com.apka.spendly.ui.screens.Statistics

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TabChooser(
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val tabs = listOf(
        "Тиждень",
        "Місяць",
        "Рік"
    )

    Row(
        modifier = modifier
            .height(52.dp)
            .padding(start = 35.dp, end = 35.dp)
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.02f),
                shape = RoundedCornerShape(90.dp)
            )
            .clip(RoundedCornerShape(90.dp))
            .background(Color(0xFF1E1E1E)),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEachIndexed { index, tab ->
            TabItem(
                text = tab,
                isSelected = selectedIndex == index,
                onClick = {
                    onTabSelected(index)
                    Log.i("HUYPIZDAVAGINA", "index: $index, tab: $tab")
                }
            )
        }
    }
}

@Composable
fun RowScope.TabItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) Color(0xFF7C3AED) else Color.Transparent,
        animationSpec = tween(300),
        label = "background"
    )

    val textColor by animateColorAsState(
        targetValue = if (isSelected) Color.White else Color.Gray,
        animationSpec = tween(300),
        label = "textColor"
    )

    Box(
        modifier = Modifier
            .weight(1f)
            .padding(4.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(90.dp))
            .background(backgroundColor)
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 13.sp,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            color = textColor
        )
    }
}
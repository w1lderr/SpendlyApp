package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FoodIcon: ImageVector
    get() {
        if (_Foodanddrinks != null) {
            return _Foodanddrinks!!
        }
        _Foodanddrinks = ImageVector.Builder(
            name = "Foodanddrinks",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(280f, 880f)
                verticalLineToRelative(-366f)
                quadToRelative(-51f, -14f, -85.5f, -56f)
                reflectiveQuadTo(160f, 360f)
                verticalLineToRelative(-280f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(280f)
                horizontalLineToRelative(40f)
                verticalLineToRelative(-280f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(280f)
                horizontalLineToRelative(40f)
                verticalLineToRelative(-280f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(280f)
                quadToRelative(0f, 56f, -34.5f, 98f)
                reflectiveQuadTo(360f, 514f)
                verticalLineToRelative(366f)
                horizontalLineToRelative(-80f)
                close()
                moveTo(680f, 880f)
                verticalLineToRelative(-320f)
                lineTo(560f, 560f)
                verticalLineToRelative(-280f)
                quadToRelative(0f, -83f, 58.5f, -141.5f)
                reflectiveQuadTo(760f, 80f)
                verticalLineToRelative(800f)
                horizontalLineToRelative(-80f)
                close()
            }
        }.build()

        return _Foodanddrinks!!
    }

@Suppress("ObjectPropertyName")
private var _Foodanddrinks: ImageVector? = null

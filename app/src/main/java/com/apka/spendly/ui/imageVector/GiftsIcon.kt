package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val GiftsIcon: ImageVector
    get() {
        if (_Gifts != null) {
            return _Gifts!!
        }
        _Gifts = ImageVector.Builder(
            name = "Gifts",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(160f, 880f)
                verticalLineToRelative(-440f)
                lineTo(80f, 440f)
                verticalLineToRelative(-240f)
                horizontalLineToRelative(208f)
                quadToRelative(-5f, -9f, -6.5f, -19f)
                reflectiveQuadToRelative(-1.5f, -21f)
                quadToRelative(0f, -50f, 35f, -85f)
                reflectiveQuadToRelative(85f, -35f)
                quadToRelative(23f, 0f, 43f, 8.5f)
                reflectiveQuadToRelative(37f, 23.5f)
                quadToRelative(17f, -16f, 37f, -24f)
                reflectiveQuadToRelative(43f, -8f)
                quadToRelative(50f, 0f, 85f, 35f)
                reflectiveQuadToRelative(35f, 85f)
                quadToRelative(0f, 11f, -2f, 20.5f)
                reflectiveQuadToRelative(-6f, 19.5f)
                horizontalLineToRelative(208f)
                verticalLineToRelative(240f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(440f)
                lineTo(160f, 880f)
                close()
                moveTo(560f, 120f)
                quadToRelative(-17f, 0f, -28.5f, 11.5f)
                reflectiveQuadTo(520f, 160f)
                quadToRelative(0f, 17f, 11.5f, 28.5f)
                reflectiveQuadTo(560f, 200f)
                quadToRelative(17f, 0f, 28.5f, -11.5f)
                reflectiveQuadTo(600f, 160f)
                quadToRelative(0f, -17f, -11.5f, -28.5f)
                reflectiveQuadTo(560f, 120f)
                close()
                moveTo(360f, 160f)
                quadToRelative(0f, 17f, 11.5f, 28.5f)
                reflectiveQuadTo(400f, 200f)
                quadToRelative(17f, 0f, 28.5f, -11.5f)
                reflectiveQuadTo(440f, 160f)
                quadToRelative(0f, -17f, -11.5f, -28.5f)
                reflectiveQuadTo(400f, 120f)
                quadToRelative(-17f, 0f, -28.5f, 11.5f)
                reflectiveQuadTo(360f, 160f)
                close()
                moveTo(160f, 280f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(280f)
                verticalLineToRelative(-80f)
                lineTo(160f, 280f)
                close()
                moveTo(440f, 800f)
                verticalLineToRelative(-360f)
                lineTo(240f, 440f)
                verticalLineToRelative(360f)
                horizontalLineToRelative(200f)
                close()
                moveTo(520f, 800f)
                horizontalLineToRelative(200f)
                verticalLineToRelative(-360f)
                lineTo(520f, 440f)
                verticalLineToRelative(360f)
                close()
                moveTo(800f, 360f)
                verticalLineToRelative(-80f)
                lineTo(520f, 280f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(280f)
                close()
            }
        }.build()

        return _Gifts!!
    }

@Suppress("ObjectPropertyName")
private var _Gifts: ImageVector? = null

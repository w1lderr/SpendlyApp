package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ClothesIcon: ImageVector
    get() {
        if (_Clothes != null) {
            return _Clothes!!
        }
        _Clothes = ImageVector.Builder(
            name = "Clothes",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(120f, 800f)
                quadToRelative(-17f, 0f, -28.5f, -11.5f)
                reflectiveQuadTo(80f, 760f)
                quadToRelative(0f, -10f, 4f, -18.5f)
                reflectiveQuadTo(96f, 728f)
                lineToRelative(344f, -258f)
                verticalLineToRelative(-70f)
                quadToRelative(0f, -17f, 12f, -28.5f)
                reflectiveQuadToRelative(29f, -11.5f)
                quadToRelative(25f, 0f, 42f, -18f)
                reflectiveQuadToRelative(17f, -43f)
                quadToRelative(0f, -25f, -17.5f, -42f)
                reflectiveQuadTo(480f, 240f)
                quadToRelative(-25f, 0f, -42.5f, 17.5f)
                reflectiveQuadTo(420f, 300f)
                horizontalLineToRelative(-80f)
                quadToRelative(0f, -58f, 41f, -99f)
                reflectiveQuadToRelative(99f, -41f)
                quadToRelative(58f, 0f, 99f, 40.5f)
                reflectiveQuadToRelative(41f, 98.5f)
                quadToRelative(0f, 47f, -27.5f, 84f)
                reflectiveQuadTo(520f, 434f)
                verticalLineToRelative(36f)
                lineToRelative(344f, 258f)
                quadToRelative(8f, 5f, 12f, 13.5f)
                reflectiveQuadToRelative(4f, 18.5f)
                quadToRelative(0f, 17f, -11.5f, 28.5f)
                reflectiveQuadTo(840f, 800f)
                lineTo(120f, 800f)
                close()
                moveTo(240f, 720f)
                horizontalLineToRelative(480f)
                lineTo(480f, 540f)
                lineTo(240f, 720f)
                close()
            }
        }.build()

        return _Clothes!!
    }

@Suppress("ObjectPropertyName")
private var _Clothes: ImageVector? = null

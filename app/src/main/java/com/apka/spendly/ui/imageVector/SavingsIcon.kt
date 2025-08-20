package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val SavingsIcon: ImageVector
    get() {
        if (_Savings != null) {
            return _Savings!!
        }
        _Savings = ImageVector.Builder(
            name = "Savings",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(640f, 440f)
                quadToRelative(17f, 0f, 28.5f, -11.5f)
                reflectiveQuadTo(680f, 400f)
                quadToRelative(0f, -17f, -11.5f, -28.5f)
                reflectiveQuadTo(640f, 360f)
                quadToRelative(-17f, 0f, -28.5f, 11.5f)
                reflectiveQuadTo(600f, 400f)
                quadToRelative(0f, 17f, 11.5f, 28.5f)
                reflectiveQuadTo(640f, 440f)
                close()
                moveTo(320f, 340f)
                horizontalLineToRelative(200f)
                verticalLineToRelative(-60f)
                lineTo(320f, 280f)
                verticalLineToRelative(60f)
                close()
                moveTo(180f, 840f)
                quadToRelative(-34f, -114f, -67f, -227.5f)
                reflectiveQuadTo(80f, 380f)
                quadToRelative(0f, -92f, 64f, -156f)
                reflectiveQuadToRelative(156f, -64f)
                horizontalLineToRelative(200f)
                quadToRelative(29f, -38f, 70.5f, -59f)
                reflectiveQuadToRelative(89.5f, -21f)
                quadToRelative(25f, 0f, 42.5f, 17.5f)
                reflectiveQuadTo(720f, 140f)
                quadToRelative(0f, 6f, -1.5f, 12f)
                reflectiveQuadToRelative(-3.5f, 11f)
                quadToRelative(-4f, 11f, -7.5f, 22.5f)
                reflectiveQuadTo(702f, 209f)
                lineToRelative(91f, 91f)
                horizontalLineToRelative(87f)
                verticalLineToRelative(279f)
                lineToRelative(-113f, 37f)
                lineToRelative(-67f, 224f)
                lineTo(480f, 840f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(80f)
                lineTo(180f, 840f)
                close()
                moveTo(225f, 780f)
                horizontalLineToRelative(115f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(200f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(115f)
                lineToRelative(63f, -210f)
                lineToRelative(102f, -35f)
                verticalLineToRelative(-175f)
                horizontalLineToRelative(-52f)
                lineTo(640f, 232f)
                quadToRelative(1f, -25f, 6.5f, -48.5f)
                reflectiveQuadTo(658f, 136f)
                quadToRelative(-38f, 10f, -72f, 29.5f)
                reflectiveQuadTo(534f, 220f)
                lineTo(300f, 220f)
                quadToRelative(-66.29f, 0f, -113.14f, 46.86f)
                quadTo(140f, 313.71f, 140f, 380f)
                quadToRelative(0f, 103.16f, 29f, 201.58f)
                quadTo(198f, 680f, 225f, 780f)
                close()
                moveTo(480f, 458f)
                close()
            }
        }.build()

        return _Savings!!
    }

@Suppress("ObjectPropertyName")
private var _Savings: ImageVector? = null

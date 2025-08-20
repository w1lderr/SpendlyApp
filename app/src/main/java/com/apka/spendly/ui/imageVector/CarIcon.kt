package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val CarIcon: ImageVector
    get() {
        if (_Car != null) {
            return _Car!!
        }
        _Car = ImageVector.Builder(
            name = "Car",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(200f, 756f)
                verticalLineToRelative(54f)
                quadToRelative(0f, 12.75f, -8.62f, 21.37f)
                quadTo(182.75f, 840f, 170f, 840f)
                horizontalLineToRelative(-20f)
                quadToRelative(-12.75f, 0f, -21.37f, -8.63f)
                quadTo(120f, 822.75f, 120f, 810f)
                verticalLineToRelative(-324f)
                lineToRelative(85f, -256f)
                quadToRelative(5f, -14f, 16.5f, -22f)
                reflectiveQuadToRelative(26.5f, -8f)
                horizontalLineToRelative(464f)
                quadToRelative(15f, 0f, 26.5f, 8f)
                reflectiveQuadToRelative(16.5f, 22f)
                lineToRelative(85f, 256f)
                verticalLineToRelative(324f)
                quadToRelative(0f, 12.75f, -8.62f, 21.37f)
                quadTo(822.75f, 840f, 810f, 840f)
                horizontalLineToRelative(-21f)
                quadToRelative(-13f, 0f, -21f, -8.63f)
                quadToRelative(-8f, -8.62f, -8f, -21.37f)
                verticalLineToRelative(-54f)
                lineTo(200f, 756f)
                close()
                moveTo(203f, 426f)
                horizontalLineToRelative(554f)
                lineToRelative(-55f, -166f)
                lineTo(258f, 260f)
                lineToRelative(-55f, 166f)
                close()
                moveTo(180f, 486f)
                verticalLineToRelative(210f)
                verticalLineToRelative(-210f)
                close()
                moveTo(285.76f, 646f)
                quadToRelative(23.24f, 0f, 38.74f, -15.75f)
                quadTo(340f, 614.5f, 340f, 592f)
                quadToRelative(0f, -23.33f, -15.75f, -39.67f)
                quadTo(308.5f, 536f, 286f, 536f)
                quadToRelative(-23.33f, 0f, -39.67f, 16.26f)
                quadTo(230f, 568.53f, 230f, 591.76f)
                quadToRelative(0f, 23.24f, 16.26f, 38.74f)
                quadToRelative(16.27f, 15.5f, 39.5f, 15.5f)
                close()
                moveTo(675f, 646f)
                quadToRelative(23.33f, 0f, 39.67f, -15.75f)
                quadTo(731f, 614.5f, 731f, 592f)
                quadToRelative(0f, -23.33f, -16.26f, -39.67f)
                quadTo(698.47f, 536f, 675.24f, 536f)
                quadToRelative(-23.24f, 0f, -38.74f, 16.26f)
                quadToRelative(-15.5f, 16.27f, -15.5f, 39.5f)
                quadToRelative(0f, 23.24f, 15.75f, 38.74f)
                quadTo(652.5f, 646f, 675f, 646f)
                close()
                moveTo(180f, 696f)
                horizontalLineToRelative(600f)
                verticalLineToRelative(-210f)
                lineTo(180f, 486f)
                verticalLineToRelative(210f)
                close()
            }
        }.build()

        return _Car!!
    }

@Suppress("ObjectPropertyName")
private var _Car: ImageVector? = null

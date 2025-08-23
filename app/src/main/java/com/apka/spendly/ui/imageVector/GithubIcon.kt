package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val GithubIcon: ImageVector
    get() {
        if (_GithubIcon != null) {
            return _GithubIcon!!
        }
        _GithubIcon = ImageVector.Builder(
            name = "GithubIcon",
            defaultWidth = 1792.dp,
            defaultHeight = 1792.dp,
            viewportWidth = 1792f,
            viewportHeight = 1792f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(1664f, 896f)
                quadToRelative(0f, 251f, -146.5f, 451.5f)
                reflectiveQuadTo(1139f, 1625f)
                quadToRelative(-27f, 5f, -39.5f, -7f)
                reflectiveQuadToRelative(-12.5f, -30f)
                verticalLineToRelative(-211f)
                quadToRelative(0f, -97f, -52f, -142f)
                quadToRelative(57f, -6f, 102.5f, -18f)
                reflectiveQuadToRelative(94f, -39f)
                reflectiveQuadToRelative(81f, -66.5f)
                reflectiveQuadToRelative(53f, -105f)
                reflectiveQuadTo(1386f, 856f)
                quadToRelative(0f, -121f, -79f, -206f)
                quadToRelative(37f, -91f, -8f, -204f)
                quadToRelative(-28f, -9f, -81f, 11f)
                reflectiveQuadToRelative(-92f, 44f)
                lineToRelative(-38f, 24f)
                quadToRelative(-93f, -26f, -192f, -26f)
                reflectiveQuadToRelative(-192f, 26f)
                quadToRelative(-16f, -11f, -42.5f, -27f)
                reflectiveQuadTo(578f, 459.5f)
                reflectiveQuadTo(492f, 446f)
                quadToRelative(-44f, 113f, -7f, 204f)
                quadToRelative(-79f, 85f, -79f, 206f)
                quadToRelative(0f, 85f, 20.5f, 150f)
                reflectiveQuadToRelative(52.5f, 105f)
                reflectiveQuadToRelative(80.5f, 67f)
                reflectiveQuadToRelative(94f, 39f)
                reflectiveQuadToRelative(102.5f, 18f)
                quadToRelative(-40f, 36f, -49f, 103f)
                quadToRelative(-21f, 10f, -45f, 15f)
                reflectiveQuadToRelative(-57f, 5f)
                reflectiveQuadToRelative(-65.5f, -21.5f)
                reflectiveQuadTo(484f, 1274f)
                quadToRelative(-19f, -32f, -48.5f, -52f)
                reflectiveQuadToRelative(-49.5f, -24f)
                lineToRelative(-20f, -3f)
                quadToRelative(-21f, 0f, -29f, 4.5f)
                reflectiveQuadToRelative(-5f, 11.5f)
                reflectiveQuadToRelative(9f, 14f)
                reflectiveQuadToRelative(13f, 12f)
                lineToRelative(7f, 5f)
                quadToRelative(22f, 10f, 43.5f, 38f)
                reflectiveQuadToRelative(31.5f, 51f)
                lineToRelative(10f, 23f)
                quadToRelative(13f, 38f, 44f, 61.5f)
                reflectiveQuadToRelative(67f, 30f)
                reflectiveQuadToRelative(69.5f, 7f)
                reflectiveQuadToRelative(55.5f, -3.5f)
                lineToRelative(23f, -4f)
                quadToRelative(0f, 38f, 0.5f, 89f)
                reflectiveQuadToRelative(0.5f, 54f)
                quadToRelative(0f, 18f, -13f, 30f)
                reflectiveQuadToRelative(-40f, 7f)
                quadToRelative(-232f, -77f, -378.5f, -277.5f)
                reflectiveQuadTo(128f, 896f)
                quadToRelative(0f, -209f, 103f, -385.5f)
                reflectiveQuadTo(510.5f, 231f)
                reflectiveQuadTo(896f, 128f)
                reflectiveQuadToRelative(385.5f, 103f)
                reflectiveQuadTo(1561f, 510.5f)
                reflectiveQuadTo(1664f, 896f)
                close()
            }
        }.build()

        return _GithubIcon!!
    }

@Suppress("ObjectPropertyName")
private var _GithubIcon: ImageVector? = null

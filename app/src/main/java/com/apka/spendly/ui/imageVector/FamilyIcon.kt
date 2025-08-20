package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FamilyIcon: ImageVector
    get() {
        if (_Familyandkids != null) {
            return _Familyandkids!!
        }
        _Familyandkids = ImageVector.Builder(
            name = "Familyandkids",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(720f, 240f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(640f, 160f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(720f, 80f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(800f, 160f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(720f, 240f)
                close()
                moveTo(680f, 880f)
                verticalLineToRelative(-320f)
                quadToRelative(0f, -40f, -20.5f, -72f)
                reflectiveQuadTo(607f, 438f)
                lineToRelative(35f, -103f)
                quadToRelative(8f, -25f, 29.5f, -40f)
                reflectiveQuadToRelative(48.5f, -15f)
                quadToRelative(27f, 0f, 48.5f, 15f)
                reflectiveQuadToRelative(29.5f, 40f)
                lineToRelative(102f, 305f)
                lineTo(800f, 640f)
                verticalLineToRelative(240f)
                lineTo(680f, 880f)
                close()
                moveTo(500f, 460f)
                quadToRelative(-25f, 0f, -42.5f, -17.5f)
                reflectiveQuadTo(440f, 400f)
                quadToRelative(0f, -25f, 17.5f, -42.5f)
                reflectiveQuadTo(500f, 340f)
                quadToRelative(25f, 0f, 42.5f, 17.5f)
                reflectiveQuadTo(560f, 400f)
                quadToRelative(0f, 25f, -17.5f, 42.5f)
                reflectiveQuadTo(500f, 460f)
                close()
                moveTo(220f, 240f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(140f, 160f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(220f, 80f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(300f, 160f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(220f, 240f)
                close()
                moveTo(140f, 880f)
                verticalLineToRelative(-280f)
                lineTo(80f, 600f)
                verticalLineToRelative(-240f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(160f, 280f)
                horizontalLineToRelative(120f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(360f, 360f)
                verticalLineToRelative(240f)
                horizontalLineToRelative(-60f)
                verticalLineToRelative(280f)
                lineTo(140f, 880f)
                close()
                moveTo(440f, 880f)
                verticalLineToRelative(-160f)
                horizontalLineToRelative(-40f)
                verticalLineToRelative(-160f)
                quadToRelative(0f, -25f, 17.5f, -42.5f)
                reflectiveQuadTo(460f, 500f)
                horizontalLineToRelative(80f)
                quadToRelative(25f, 0f, 42.5f, 17.5f)
                reflectiveQuadTo(600f, 560f)
                verticalLineToRelative(160f)
                horizontalLineToRelative(-40f)
                verticalLineToRelative(160f)
                lineTo(440f, 880f)
                close()
            }
        }.build()

        return _Familyandkids!!
    }

@Suppress("ObjectPropertyName")
private var _Familyandkids: ImageVector? = null

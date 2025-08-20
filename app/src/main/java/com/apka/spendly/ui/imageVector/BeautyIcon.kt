package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val BeautyIcon: ImageVector
    get() {
        if (_Healthandbeauty != null) {
            return _Healthandbeauty!!
        }
        _Healthandbeauty = ImageVector.Builder(
            name = "Healthandbeauty",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(200f, 880f)
                lineTo(40f, 440f)
                lineToRelative(200f, -120f)
                verticalLineToRelative(-240f)
                horizontalLineToRelative(160f)
                verticalLineToRelative(240f)
                lineToRelative(200f, 120f)
                lineTo(440f, 880f)
                lineTo(200f, 880f)
                close()
                moveTo(680f, 880f)
                quadToRelative(-17f, 0f, -28.5f, -11.5f)
                reflectiveQuadTo(640f, 840f)
                quadToRelative(0f, -17f, 11.5f, -28.5f)
                reflectiveQuadTo(680f, 800f)
                horizontalLineToRelative(120f)
                verticalLineToRelative(-80f)
                lineTo(680f, 720f)
                quadToRelative(-17f, 0f, -28.5f, -11.5f)
                reflectiveQuadTo(640f, 680f)
                quadToRelative(0f, -17f, 11.5f, -28.5f)
                reflectiveQuadTo(680f, 640f)
                horizontalLineToRelative(120f)
                verticalLineToRelative(-80f)
                lineTo(680f, 560f)
                quadToRelative(-17f, 0f, -28.5f, -11.5f)
                reflectiveQuadTo(640f, 520f)
                quadToRelative(0f, -17f, 11.5f, -28.5f)
                reflectiveQuadTo(680f, 480f)
                horizontalLineToRelative(120f)
                verticalLineToRelative(-80f)
                lineTo(680f, 400f)
                quadToRelative(-17f, 0f, -28.5f, -11.5f)
                reflectiveQuadTo(640f, 360f)
                quadToRelative(0f, -17f, 11.5f, -28.5f)
                reflectiveQuadTo(680f, 320f)
                horizontalLineToRelative(120f)
                verticalLineToRelative(-80f)
                lineTo(680f, 240f)
                quadToRelative(-17f, 0f, -28.5f, -11.5f)
                reflectiveQuadTo(640f, 200f)
                quadToRelative(0f, -17f, 11.5f, -28.5f)
                reflectiveQuadTo(680f, 160f)
                horizontalLineToRelative(160f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(920f, 240f)
                verticalLineToRelative(560f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(840f, 880f)
                lineTo(680f, 880f)
                close()
                moveTo(256f, 800f)
                horizontalLineToRelative(128f)
                lineToRelative(118f, -326f)
                lineToRelative(-124f, -74f)
                lineTo(262f, 400f)
                lineToRelative(-124f, 74f)
                lineToRelative(118f, 326f)
                close()
                moveTo(320f, 600f)
                close()
            }
        }.build()

        return _Healthandbeauty!!
    }

@Suppress("ObjectPropertyName")
private var _Healthandbeauty: ImageVector? = null

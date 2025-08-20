package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val HealthIcon: ImageVector
    get() {
        if (_Heath != null) {
            return _Heath!!
        }
        _Heath = ImageVector.Builder(
            name = "Heath",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(327f, 840f)
                verticalLineToRelative(-207f)
                lineTo(120f, 633f)
                verticalLineToRelative(-307f)
                horizontalLineToRelative(207f)
                verticalLineToRelative(-206f)
                horizontalLineToRelative(307f)
                verticalLineToRelative(206f)
                horizontalLineToRelative(206f)
                verticalLineToRelative(307f)
                lineTo(634f, 633f)
                verticalLineToRelative(207f)
                lineTo(327f, 840f)
                close()
                moveTo(387f, 780f)
                horizontalLineToRelative(187f)
                verticalLineToRelative(-207f)
                horizontalLineToRelative(206f)
                verticalLineToRelative(-187f)
                lineTo(574f, 386f)
                verticalLineToRelative(-206f)
                lineTo(387f, 180f)
                verticalLineToRelative(206f)
                lineTo(180f, 386f)
                verticalLineToRelative(187f)
                horizontalLineToRelative(207f)
                verticalLineToRelative(207f)
                close()
                moveTo(480f, 480f)
                close()
            }
        }.build()

        return _Heath!!
    }

@Suppress("ObjectPropertyName")
private var _Heath: ImageVector? = null

package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val TravelIcon: ImageVector
    get() {
        if (_Travel != null) {
            return _Travel!!
        }
        _Travel = ImageVector.Builder(
            name = "Travel",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveToRelative(393f, 841f)
                lineToRelative(-95f, -179f)
                lineToRelative(-180f, -96f)
                lineToRelative(59f, -59f)
                lineToRelative(148f, 27f)
                lineToRelative(122f, -121f)
                lineToRelative(-327f, -139f)
                lineToRelative(72f, -72f)
                lineToRelative(396f, 69f)
                lineToRelative(133f, -133f)
                quadToRelative(21f, -21f, 50.5f, -21f)
                reflectiveQuadToRelative(50.5f, 21f)
                quadToRelative(21f, 21f, 21f, 50.5f)
                reflectiveQuadTo(822f, 239f)
                lineTo(689f, 372f)
                lineToRelative(69f, 396f)
                lineToRelative(-72f, 72f)
                lineToRelative(-139f, -327f)
                lineToRelative(-121f, 122f)
                lineToRelative(26f, 147f)
                lineToRelative(-59f, 59f)
                close()
            }
        }.build()

        return _Travel!!
    }

@Suppress("ObjectPropertyName")
private var _Travel: ImageVector? = null

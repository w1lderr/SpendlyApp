package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val HousingIcon: ImageVector
    get() {
        if (_House != null) {
            return _House!!
        }
        _House = ImageVector.Builder(
            name = "House",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(201f, 800f)
                verticalLineToRelative(-392f)
                lineTo(76f, 503f)
                lineToRelative(-36f, -47f)
                lineToRelative(440f, -336f)
                lineToRelative(178f, 136f)
                verticalLineToRelative(-96f)
                horizontalLineToRelative(100f)
                verticalLineToRelative(172f)
                lineToRelative(162f, 124f)
                lineToRelative(-37f, 47f)
                lineToRelative(-125f, -96f)
                verticalLineToRelative(393f)
                lineTo(530f, 800f)
                verticalLineToRelative(-240f)
                lineTo(430f, 560f)
                verticalLineToRelative(240f)
                lineTo(201f, 800f)
                close()
                moveTo(261f, 740f)
                horizontalLineToRelative(109f)
                verticalLineToRelative(-240f)
                horizontalLineToRelative(220f)
                verticalLineToRelative(240f)
                horizontalLineToRelative(108f)
                verticalLineToRelative(-378f)
                lineTo(480f, 195f)
                lineTo(261f, 362f)
                verticalLineToRelative(378f)
                close()
                moveTo(395f, 390f)
                horizontalLineToRelative(170f)
                quadToRelative(0f, -33f, -25.5f, -54.5f)
                reflectiveQuadTo(480f, 314f)
                quadToRelative(-34f, 0f, -59.5f, 21.34f)
                reflectiveQuadTo(395f, 390f)
                close()
                moveTo(370f, 740f)
                verticalLineToRelative(-240f)
                horizontalLineToRelative(220f)
                verticalLineToRelative(240f)
                verticalLineToRelative(-240f)
                lineTo(370f, 500f)
                verticalLineToRelative(240f)
                close()
            }
        }.build()

        return _House!!
    }

@Suppress("ObjectPropertyName")
private var _House: ImageVector? = null

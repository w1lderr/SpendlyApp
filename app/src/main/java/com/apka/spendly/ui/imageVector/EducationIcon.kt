package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EducationIcon: ImageVector
    get() {
        if (_Education != null) {
            return _Education!!
        }
        _Education = ImageVector.Builder(
            name = "Education",
            defaultWidth = 48.dp,
            defaultHeight = 48.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveTo(479f, 840f)
                lineTo(189f, 681f)
                verticalLineToRelative(-240f)
                lineTo(40f, 360f)
                lineToRelative(439f, -240f)
                lineToRelative(441f, 240f)
                verticalLineToRelative(317f)
                horizontalLineToRelative(-60f)
                verticalLineToRelative(-282f)
                lineToRelative(-91f, 46f)
                verticalLineToRelative(240f)
                lineTo(479f, 840f)
                close()
                moveTo(479f, 532f)
                lineTo(794f, 360f)
                lineTo(479f, 191f)
                lineTo(166f, 360f)
                lineTo(479f, 532f)
                close()
                moveTo(479f, 772f)
                lineTo(709f, 645f)
                verticalLineToRelative(-168f)
                lineTo(479f, 600f)
                lineTo(249f, 475f)
                verticalLineToRelative(170f)
                lineToRelative(230f, 127f)
                close()
                moveTo(480f, 532f)
                close()
                moveTo(479f, 606f)
                close()
                moveTo(479f, 606f)
                close()
            }
        }.build()

        return _Education!!
    }

@Suppress("ObjectPropertyName")
private var _Education: ImageVector? = null

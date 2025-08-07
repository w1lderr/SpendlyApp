package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ExitIcon: ImageVector
    get() {
        if (_ExitIcon != null) {
            return _ExitIcon!!
        }
        _ExitIcon = ImageVector.Builder(
            name = "ExitIcon",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(11.75f, 10f)
                lineTo(19.625f, 2.125f)
                curveTo(20.125f, 1.625f, 20.125f, 0.875f, 19.625f, 0.375f)
                curveTo(19.125f, -0.125f, 18.375f, -0.125f, 17.875f, 0.375f)
                lineTo(10f, 8.25f)
                lineTo(2.125f, 0.375f)
                curveTo(1.625f, -0.125f, 0.875f, -0.125f, 0.375f, 0.375f)
                curveTo(-0.125f, 0.875f, -0.125f, 1.625f, 0.375f, 2.125f)
                lineTo(8.25f, 10f)
                lineTo(0.375f, 17.875f)
                curveTo(0.125f, 18.125f, 0f, 18.375f, 0f, 18.75f)
                curveTo(0f, 19.5f, 0.5f, 20f, 1.25f, 20f)
                curveTo(1.625f, 20f, 1.875f, 19.875f, 2.125f, 19.625f)
                lineTo(10f, 11.75f)
                lineTo(17.875f, 19.625f)
                curveTo(18.125f, 19.875f, 18.375f, 20f, 18.75f, 20f)
                curveTo(19.125f, 20f, 19.375f, 19.875f, 19.625f, 19.625f)
                curveTo(20.125f, 19.125f, 20.125f, 18.375f, 19.625f, 17.875f)
                lineTo(11.75f, 10f)
                close()
            }
        }.build()

        return _ExitIcon!!
    }

@Suppress("ObjectPropertyName")
private var _ExitIcon: ImageVector? = null
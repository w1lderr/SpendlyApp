package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ProfileIcon: ImageVector
    get() {
        if (_ProfileIcon != null) {
            return _ProfileIcon!!
        }
        _ProfileIcon = ImageVector.Builder(
            name = "ProfileIcon",
            defaultWidth = 47.dp,
            defaultHeight = 47.dp,
            viewportWidth = 47f,
            viewportHeight = 47f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF2A2D32)),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f
            ) {
                moveTo(23.5f, 47f)
                curveTo(36.479f, 47f, 47f, 36.479f, 47f, 23.5f)
                curveTo(47f, 10.521f, 36.479f, 0f, 23.5f, 0f)
                curveTo(10.521f, 0f, 0f, 10.521f, 0f, 23.5f)
                curveTo(0f, 36.479f, 10.521f, 47f, 23.5f, 47f)
                close()
            }
            path(fill = SolidColor(Color(0xFF34383E))) {
                moveTo(23.5f, 11.585f)
                curveTo(18.635f, 11.585f, 14.688f, 15.533f, 14.688f, 20.398f)
                curveTo(14.688f, 25.168f, 18.424f, 29.046f, 23.382f, 29.187f)
                curveTo(23.453f, 29.187f, 23.547f, 29.187f, 23.594f, 29.187f)
                curveTo(23.641f, 29.187f, 23.712f, 29.187f, 23.758f, 29.187f)
                curveTo(23.782f, 29.187f, 23.806f, 29.187f, 23.806f, 29.187f)
                curveTo(28.552f, 29.022f, 32.289f, 25.168f, 32.313f, 20.398f)
                curveTo(32.313f, 15.533f, 28.365f, 11.585f, 23.5f, 11.585f)
                close()
            }
            path(fill = SolidColor(Color(0xFF34383E))) {
                moveTo(39.435f, 40.773f)
                curveTo(35.252f, 44.627f, 29.659f, 47f, 23.502f, 47f)
                curveTo(17.345f, 47f, 11.752f, 44.627f, 7.569f, 40.773f)
                curveTo(8.133f, 38.634f, 9.66f, 36.684f, 11.893f, 35.18f)
                curveTo(18.308f, 30.903f, 28.742f, 30.903f, 35.111f, 35.18f)
                curveTo(37.367f, 36.684f, 38.871f, 38.634f, 39.435f, 40.773f)
                close()
            }
        }.build()

        return _ProfileIcon!!
    }

@Suppress("ObjectPropertyName")
private var _ProfileIcon: ImageVector? = null
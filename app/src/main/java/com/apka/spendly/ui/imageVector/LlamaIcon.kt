package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val LlamaIcon: ImageVector
    get() {
        if (_LlamaIcon != null) {
            return _LlamaIcon!!
        }
        _LlamaIcon = ImageVector.Builder(
            name = "LlamaIcon",
            defaultWidth = 36.dp,
            defaultHeight = 24.dp,
            viewportWidth = 36f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFB7B7B7))) {
                moveTo(25.837f, 0f)
                curveTo(22.885f, 0f, 20.577f, 2.23f, 18.489f, 5.064f)
                curveTo(15.618f, 1.397f, 13.217f, 0f, 10.345f, 0f)
                curveTo(4.488f, 0f, 0f, 7.647f, 0f, 15.741f)
                curveTo(0f, 20.805f, 2.442f, 24f, 6.533f, 24f)
                curveTo(9.478f, 24f, 11.595f, 22.607f, 15.36f, 16.005f)
                curveTo(15.36f, 16.005f, 16.93f, 13.225f, 18.009f, 11.31f)
                curveTo(18.387f, 11.923f, 18.786f, 12.583f, 19.204f, 13.291f)
                lineTo(20.97f, 16.27f)
                curveTo(24.409f, 22.043f, 26.325f, 24f, 29.796f, 24f)
                curveTo(33.782f, 24f, 36f, 20.762f, 36f, 15.592f)
                curveTo(36f, 7.117f, 31.411f, 0f, 25.837f, 0f)
                close()
                moveTo(12.49f, 14.218f)
                curveTo(9.437f, 19.018f, 8.381f, 20.094f, 6.682f, 20.094f)
                curveTo(4.933f, 20.094f, 3.894f, 18.553f, 3.894f, 15.807f)
                curveTo(3.894f, 9.931f, 6.814f, 3.923f, 10.295f, 3.923f)
                curveTo(12.18f, 3.923f, 13.756f, 5.015f, 16.169f, 8.481f)
                curveTo(13.877f, 12.007f, 12.49f, 14.218f, 12.49f, 14.218f)
                close()
                moveTo(24.009f, 13.614f)
                lineTo(21.898f, 10.082f)
                curveTo(21.327f, 9.15f, 20.778f, 8.292f, 20.252f, 7.509f)
                curveTo(22.154f, 4.563f, 23.723f, 3.095f, 25.589f, 3.095f)
                curveTo(29.466f, 3.095f, 32.568f, 8.822f, 32.568f, 15.856f)
                curveTo(32.568f, 18.538f, 31.693f, 20.094f, 29.879f, 20.094f)
                curveTo(28.14f, 20.094f, 27.31f, 18.942f, 24.009f, 13.614f)
                close()
            }
        }.build()

        return _LlamaIcon!!
    }

@Suppress("ObjectPropertyName")
private var _LlamaIcon: ImageVector? = null
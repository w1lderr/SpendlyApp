package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val BellIcon: ImageVector
    get() {
        if (_BellIcon != null) {
            return _BellIcon!!
        }
        _BellIcon = ImageVector.Builder(
            name = "BellIcon",
            defaultWidth = 28.dp,
            defaultHeight = 30.dp,
            viewportWidth = 28f,
            viewportHeight = 30f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(14.842f, 3.601f)
                curveTo(14.842f, 3.104f, 14.466f, 2.701f, 14.002f, 2.701f)
                curveTo(13.538f, 2.701f, 13.162f, 3.104f, 13.162f, 3.601f)
                verticalLineTo(4.546f)
                curveTo(8.917f, 4.997f, 5.602f, 8.834f, 5.602f, 13.501f)
                verticalLineTo(17.238f)
                lineTo(4.826f, 19.453f)
                curveTo(4.209f, 21.218f, 5.426f, 23.101f, 7.186f, 23.101f)
                horizontalLineTo(20.817f)
                curveTo(22.577f, 23.101f, 23.795f, 21.218f, 23.177f, 19.453f)
                lineTo(22.402f, 17.238f)
                verticalLineTo(13.501f)
                curveTo(22.402f, 8.834f, 19.087f, 4.997f, 14.842f, 4.546f)
                verticalLineTo(3.601f)
                close()
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(17.218f, 24.301f)
                horizontalLineTo(10.781f)
                curveTo(11.266f, 25.702f, 12.524f, 26.699f, 14f, 26.699f)
                curveTo(15.475f, 26.699f, 16.734f, 25.702f, 17.218f, 24.301f)
                close()
            }
        }.build()

        return _BellIcon!!
    }

@Suppress("ObjectPropertyName")
private var _BellIcon: ImageVector? = null
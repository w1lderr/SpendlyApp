package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val DescriptionIcon: ImageVector
    get() {
        if (_DescriptionIcon != null) {
            return _DescriptionIcon!!
        }
        _DescriptionIcon = ImageVector.Builder(
            name = "DescriptionIcon",
            defaultWidth = 25.dp,
            defaultHeight = 32.dp,
            viewportWidth = 25f,
            viewportHeight = 32f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(6.25f, 22.4f)
                horizontalLineTo(18.75f)
                verticalLineTo(25.6f)
                horizontalLineTo(6.25f)
                verticalLineTo(22.4f)
                close()
                moveTo(6.25f, 16f)
                horizontalLineTo(18.75f)
                verticalLineTo(19.2f)
                horizontalLineTo(6.25f)
                verticalLineTo(16f)
                close()
                moveTo(15.625f, 0f)
                horizontalLineTo(3.125f)
                curveTo(1.406f, 0f, 0f, 1.44f, 0f, 3.2f)
                verticalLineTo(28.8f)
                curveTo(0f, 30.56f, 1.391f, 32f, 3.109f, 32f)
                horizontalLineTo(21.875f)
                curveTo(23.594f, 32f, 25f, 30.56f, 25f, 28.8f)
                verticalLineTo(9.6f)
                lineTo(15.625f, 0f)
                close()
                moveTo(21.875f, 28.8f)
                horizontalLineTo(3.125f)
                verticalLineTo(3.2f)
                horizontalLineTo(14.063f)
                verticalLineTo(11.2f)
                horizontalLineTo(21.875f)
                verticalLineTo(28.8f)
                close()
            }
        }.build()

        return _DescriptionIcon!!
    }

@Suppress("ObjectPropertyName")
private var _DescriptionIcon: ImageVector? = null
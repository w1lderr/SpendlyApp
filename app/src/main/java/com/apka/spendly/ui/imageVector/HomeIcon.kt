package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val HomeIcon: ImageVector
    get() {
        if (_HomeIcon != null) {
            return _HomeIcon!!
        }
        _HomeIcon = ImageVector.Builder(
            name = "HomeIcon",
            defaultWidth = 28.dp,
            defaultHeight = 28.dp,
            viewportWidth = 28f,
            viewportHeight = 28f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFB7B7B7)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(14.72f, 2.641f)
                curveTo(14.293f, 2.32f, 13.707f, 2.32f, 13.28f, 2.641f)
                lineTo(2.88f, 10.442f)
                curveTo(2.578f, 10.669f, 2.4f, 11.024f, 2.4f, 11.402f)
                verticalLineTo(24.399f)
                curveTo(2.4f, 25.062f, 2.937f, 25.6f, 3.6f, 25.6f)
                horizontalLineTo(9.2f)
                verticalLineTo(21.999f)
                curveTo(9.2f, 19.347f, 11.349f, 17.198f, 14f, 17.198f)
                curveTo(16.651f, 17.198f, 18.8f, 19.347f, 18.8f, 21.999f)
                verticalLineTo(25.6f)
                horizontalLineTo(24.4f)
                curveTo(25.063f, 25.6f, 25.6f, 25.062f, 25.6f, 24.399f)
                verticalLineTo(11.402f)
                curveTo(25.6f, 11.024f, 25.422f, 10.669f, 25.12f, 10.442f)
                lineTo(14.72f, 2.641f)
                close()
                moveTo(11.84f, 0.72f)
                curveTo(13.12f, -0.24f, 14.88f, -0.24f, 16.16f, 0.72f)
                lineTo(26.56f, 8.522f)
                curveTo(27.467f, 9.202f, 28f, 10.269f, 28f, 11.402f)
                verticalLineTo(24.399f)
                curveTo(28f, 26.388f, 26.388f, 28f, 24.4f, 28f)
                horizontalLineTo(17.6f)
                curveTo(16.937f, 28f, 16.4f, 27.463f, 16.4f, 26.8f)
                verticalLineTo(21.999f)
                curveTo(16.4f, 20.673f, 15.325f, 19.598f, 14f, 19.598f)
                curveTo(12.675f, 19.598f, 11.6f, 20.673f, 11.6f, 21.999f)
                verticalLineTo(26.8f)
                curveTo(11.6f, 27.463f, 11.063f, 28f, 10.4f, 28f)
                horizontalLineTo(3.6f)
                curveTo(1.612f, 28f, 0f, 26.388f, 0f, 24.399f)
                verticalLineTo(11.402f)
                curveTo(0f, 10.269f, 0.534f, 9.202f, 1.44f, 8.522f)
                lineTo(11.84f, 0.72f)
                close()
            }
        }.build()

        return _HomeIcon!!
    }

@Suppress("ObjectPropertyName")
private var _HomeIcon: ImageVector? = null

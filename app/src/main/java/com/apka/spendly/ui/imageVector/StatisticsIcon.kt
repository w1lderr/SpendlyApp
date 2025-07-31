package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val StatisticsIcon: ImageVector
    get() {
        if (_StatisticsIcon != null) {
            return _StatisticsIcon!!
        }
        _StatisticsIcon = ImageVector.Builder(
            name = "StatisticsIcon",
            defaultWidth = 32.dp,
            defaultHeight = 24.dp,
            viewportWidth = 32f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFB7B7B7))) {
                moveTo(2.542f, 1.313f)
                curveTo(2.542f, 0.657f, 2.01f, 0.125f, 1.354f, 0.125f)
                curveTo(0.698f, 0.125f, 0.167f, 0.657f, 0.167f, 1.313f)
                verticalLineTo(20.313f)
                curveTo(0.167f, 22.28f, 1.762f, 23.875f, 3.729f, 23.875f)
                horizontalLineTo(30.646f)
                curveTo(31.302f, 23.875f, 31.833f, 23.343f, 31.833f, 22.688f)
                curveTo(31.833f, 22.032f, 31.302f, 21.5f, 30.646f, 21.5f)
                horizontalLineTo(3.729f)
                curveTo(3.073f, 21.5f, 2.542f, 20.968f, 2.542f, 20.313f)
                verticalLineTo(1.313f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFB7B7B7)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(8.083f, 9.272f)
                curveTo(6.335f, 9.272f, 4.917f, 10.69f, 4.917f, 12.439f)
                verticalLineTo(17.938f)
                curveTo(4.917f, 18.594f, 5.448f, 19.125f, 6.104f, 19.125f)
                horizontalLineTo(10.063f)
                curveTo(10.718f, 19.125f, 11.25f, 18.594f, 11.25f, 17.938f)
                verticalLineTo(12.439f)
                curveTo(11.25f, 10.69f, 9.832f, 9.272f, 8.083f, 9.272f)
                close()
                moveTo(7.292f, 12.439f)
                curveTo(7.292f, 12.002f, 7.646f, 11.647f, 8.083f, 11.647f)
                curveTo(8.521f, 11.647f, 8.875f, 12.002f, 8.875f, 12.439f)
                verticalLineTo(16.75f)
                horizontalLineTo(7.292f)
                verticalLineTo(12.439f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFB7B7B7)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(13.625f, 3.292f)
                curveTo(13.625f, 1.543f, 15.043f, 0.125f, 16.792f, 0.125f)
                curveTo(18.541f, 0.125f, 19.958f, 1.543f, 19.958f, 3.292f)
                verticalLineTo(17.938f)
                curveTo(19.958f, 18.594f, 19.427f, 19.125f, 18.771f, 19.125f)
                horizontalLineTo(14.813f)
                curveTo(14.157f, 19.125f, 13.625f, 18.594f, 13.625f, 17.938f)
                verticalLineTo(3.292f)
                close()
                moveTo(16.792f, 2.5f)
                curveTo(16.354f, 2.5f, 16f, 2.854f, 16f, 3.292f)
                verticalLineTo(16.75f)
                horizontalLineTo(17.583f)
                verticalLineTo(3.292f)
                curveTo(17.583f, 2.854f, 17.229f, 2.5f, 16.792f, 2.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFB7B7B7)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(25.5f, 5.759f)
                curveTo(23.751f, 5.759f, 22.333f, 7.177f, 22.333f, 8.926f)
                verticalLineTo(17.938f)
                curveTo(22.333f, 18.594f, 22.865f, 19.125f, 23.521f, 19.125f)
                horizontalLineTo(27.479f)
                curveTo(28.135f, 19.125f, 28.667f, 18.594f, 28.667f, 17.938f)
                verticalLineTo(8.926f)
                curveTo(28.667f, 7.177f, 27.249f, 5.759f, 25.5f, 5.759f)
                close()
                moveTo(24.708f, 8.926f)
                curveTo(24.708f, 8.489f, 25.063f, 8.134f, 25.5f, 8.134f)
                curveTo(25.937f, 8.134f, 26.292f, 8.489f, 26.292f, 8.926f)
                verticalLineTo(16.75f)
                horizontalLineTo(24.708f)
                verticalLineTo(8.926f)
                close()
            }
        }.build()

        return _StatisticsIcon!!
    }

@Suppress("ObjectPropertyName")
private var _StatisticsIcon: ImageVector? = null

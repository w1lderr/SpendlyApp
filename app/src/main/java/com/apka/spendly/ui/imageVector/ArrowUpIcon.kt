package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ArrowUpIcon: ImageVector
    get() {
        if (_ArrowUpIcon != null) {
            return _ArrowUpIcon!!
        }
        _ArrowUpIcon = ImageVector.Builder(
            name = "ArrowUpIcon",
            defaultWidth = 168.dp,
            defaultHeight = 200.dp,
            viewportWidth = 168f,
            viewportHeight = 200f
        ).apply {
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 24f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(84f, 188f)
                verticalLineTo(12f)
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 24f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12f, 84f)
                lineTo(84f, 12f)
                lineTo(156f, 84f)
            }
        }.build()

        return _ArrowUpIcon!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowUpIcon: ImageVector? = null
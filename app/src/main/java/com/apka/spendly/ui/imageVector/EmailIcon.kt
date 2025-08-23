package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EmailIcon: ImageVector
    get() {
        if (_EmailIcon != null) {
            return _EmailIcon!!
        }
        _EmailIcon = ImageVector.Builder(
            name = "EmailIcon",
            defaultWidth = 128.dp,
            defaultHeight = 96.dp,
            viewportWidth = 128f,
            viewportHeight = 96f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(0f, 11.28f)
                lineTo(0f, 8f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, -8f)
                horizontalLineToRelative(112f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8f, 8f)
                verticalLineToRelative(3.28f)
                lineToRelative(-64f, 40f)
                close()
                moveTo(66.12f, 59.39f)
                arcToRelative(4f, 4f, 0f, isMoreThanHalf = false, isPositiveArc = true, -4.24f, 0f)
                lineTo(0f, 20.72f)
                lineTo(0f, 88f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 8f, 8f)
                horizontalLineToRelative(112f)
                arcToRelative(8f, 8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 8f, -8f)
                lineTo(128f, 20.72f)
                close()
            }
        }.build()

        return _EmailIcon!!
    }

@Suppress("ObjectPropertyName")
private var _EmailIcon: ImageVector? = null

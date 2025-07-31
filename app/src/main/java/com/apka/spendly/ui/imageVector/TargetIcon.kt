package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val TargetIcon: ImageVector
    get() {
        if (_TargetIcon != null) {
            return _TargetIcon!!
        }
        _TargetIcon = ImageVector.Builder(
            name = "TargetIcon",
            defaultWidth = 35.dp,
            defaultHeight = 35.dp,
            viewportWidth = 35f,
            viewportHeight = 35f
        ).apply {
            path(fill = SolidColor(Color(0xFFB7B7B7))) {
                moveTo(17.5f, 0f)
                curveTo(7.835f, 0f, 0f, 7.835f, 0f, 17.5f)
                curveTo(0f, 27.165f, 7.835f, 35f, 17.5f, 35f)
                curveTo(27.165f, 35f, 35f, 27.165f, 35f, 17.5f)
                curveTo(35f, 7.835f, 27.165f, 0f, 17.5f, 0f)
                close()
                moveTo(17.5f, 31.818f)
                curveTo(9.592f, 31.818f, 3.182f, 25.408f, 3.182f, 17.5f)
                curveTo(3.182f, 9.592f, 9.592f, 3.182f, 17.5f, 3.182f)
                curveTo(25.408f, 3.182f, 31.818f, 9.592f, 31.818f, 17.5f)
                curveTo(31.818f, 25.408f, 25.408f, 31.818f, 17.5f, 31.818f)
                close()
                moveTo(17.5f, 6.364f)
                curveTo(11.349f, 6.364f, 6.364f, 11.349f, 6.364f, 17.5f)
                curveTo(6.364f, 23.65f, 11.349f, 28.636f, 17.5f, 28.636f)
                curveTo(23.65f, 28.636f, 28.636f, 23.65f, 28.636f, 17.5f)
                curveTo(28.636f, 11.349f, 23.65f, 6.364f, 17.5f, 6.364f)
                close()
                moveTo(17.5f, 25.455f)
                curveTo(13.107f, 25.455f, 9.545f, 21.893f, 9.545f, 17.5f)
                curveTo(9.545f, 13.107f, 13.107f, 9.545f, 17.5f, 9.545f)
                curveTo(21.893f, 9.545f, 25.455f, 13.107f, 25.455f, 17.5f)
                curveTo(25.455f, 21.893f, 21.893f, 25.455f, 17.5f, 25.455f)
                close()
                moveTo(17.5f, 12.727f)
                curveTo(14.864f, 12.727f, 12.727f, 14.864f, 12.727f, 17.5f)
                curveTo(12.727f, 20.136f, 14.864f, 22.273f, 17.5f, 22.273f)
                curveTo(20.136f, 22.273f, 22.273f, 20.136f, 22.273f, 17.5f)
                curveTo(22.273f, 14.864f, 20.136f, 12.727f, 17.5f, 12.727f)
                close()
                moveTo(17.5f, 19.091f)
                curveTo(17.078f, 19.091f, 16.673f, 18.923f, 16.375f, 18.625f)
                curveTo(16.077f, 18.327f, 15.909f, 17.922f, 15.909f, 17.5f)
                curveTo(15.909f, 17.078f, 16.077f, 16.673f, 16.375f, 16.375f)
                curveTo(16.673f, 16.077f, 17.078f, 15.909f, 17.5f, 15.909f)
                curveTo(17.922f, 15.909f, 18.327f, 16.077f, 18.625f, 16.375f)
                curveTo(18.923f, 16.673f, 19.091f, 17.078f, 19.091f, 17.5f)
                curveTo(19.091f, 17.922f, 18.923f, 18.327f, 18.625f, 18.625f)
                curveTo(18.327f, 18.923f, 17.922f, 19.091f, 17.5f, 19.091f)
                close()
            }
        }.build()

        return _TargetIcon!!
    }

@Suppress("ObjectPropertyName")
private var _TargetIcon: ImageVector? = null
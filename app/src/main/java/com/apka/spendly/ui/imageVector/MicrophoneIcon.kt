package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val MicrophoneIcon: ImageVector
    get() {
        if (_Microphone != null) {
            return _Microphone!!
        }
        _Microphone = ImageVector.Builder(
            name = "Microphone",
            defaultWidth = 14.dp,
            defaultHeight = 22.dp,
            viewportWidth = 14f,
            viewportHeight = 22f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(7.538f, 17.742f)
                verticalLineTo(20.462f)
                horizontalLineTo(11.308f)
                curveTo(11.604f, 20.462f, 11.846f, 20.704f, 11.846f, 21f)
                curveTo(11.846f, 21.296f, 11.604f, 21.538f, 11.308f, 21.538f)
                horizontalLineTo(2.692f)
                curveTo(2.396f, 21.538f, 2.154f, 21.296f, 2.154f, 21f)
                curveTo(2.154f, 20.704f, 2.396f, 20.462f, 2.692f, 20.462f)
                horizontalLineTo(6.462f)
                verticalLineTo(17.742f)
                curveTo(2.854f, 17.473f, 0f, 14.431f, 0f, 10.769f)
                curveTo(0f, 10.473f, 0.242f, 10.231f, 0.538f, 10.231f)
                curveTo(0.835f, 10.231f, 1.077f, 10.473f, 1.077f, 10.769f)
                curveTo(1.077f, 14.027f, 3.742f, 16.692f, 7f, 16.692f)
                curveTo(10.258f, 16.692f, 12.923f, 14.027f, 12.923f, 10.769f)
                curveTo(12.923f, 10.473f, 13.165f, 10.231f, 13.462f, 10.231f)
                curveTo(13.758f, 10.231f, 14f, 10.473f, 14f, 10.769f)
                curveTo(14f, 14.458f, 11.146f, 17.473f, 7.538f, 17.742f)
                close()
                moveTo(11.038f, 4.038f)
                verticalLineTo(10.769f)
                curveTo(11.038f, 13.004f, 9.235f, 14.808f, 7f, 14.808f)
                curveTo(4.765f, 14.808f, 2.962f, 13.004f, 2.962f, 10.769f)
                verticalLineTo(4.038f)
                curveTo(2.962f, 1.804f, 4.765f, 0f, 7f, 0f)
                curveTo(9.235f, 0f, 11.038f, 1.804f, 11.038f, 4.038f)
                close()
                moveTo(9.962f, 4.038f)
                curveTo(9.962f, 2.396f, 8.642f, 1.077f, 7f, 1.077f)
                curveTo(5.358f, 1.077f, 4.038f, 2.396f, 4.038f, 4.038f)
                verticalLineTo(10.769f)
                curveTo(4.038f, 12.411f, 5.358f, 13.731f, 7f, 13.731f)
                curveTo(8.642f, 13.731f, 9.962f, 12.411f, 9.962f, 10.769f)
                verticalLineTo(4.038f)
                close()
            }
        }.build()

        return _Microphone!!
    }

@Suppress("ObjectPropertyName")
private var _Microphone: ImageVector? = null

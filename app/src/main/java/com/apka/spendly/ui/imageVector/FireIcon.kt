package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FireIcon: ImageVector
    get() {
        if (_FireIcon != null) {
            return _FireIcon!!
        }
        _FireIcon = ImageVector.Builder(
            name = "FireIcon",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(5.926f, 20.574f)
                arcToRelative(
                    7.26f,
                    7.26f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    3.039f,
                    1.511f
                )
                curveToRelative(0.107f, 0.035f, 0.179f, -0.105f, 0.107f, -0.175f)
                curveToRelative(-2.395f, -2.285f, -1.079f, -4.758f, -0.107f, -5.873f)
                curveToRelative(0.693f, -0.796f, 1.68f, -2.107f, 1.608f, -3.865f)
                curveToRelative(0f, -0.176f, 0.18f, -0.317f, 0.322f, -0.211f)
                curveToRelative(1.359f, 0.703f, 2.288f, 2.25f, 2.538f, 3.515f)
                curveToRelative(0.394f, -0.386f, 0.537f, -0.984f, 0.537f, -1.511f)
                curveToRelative(0f, -0.176f, 0.214f, -0.317f, 0.393f, -0.176f)
                curveToRelative(1.287f, 1.16f, 3.503f, 5.097f, -0.072f, 8.19f)
                curveToRelative(-0.071f, 0.071f, 0f, 0.212f, 0.072f, 0.177f)
                arcToRelative(
                    8.761f,
                    8.761f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    3.003f,
                    -1.442f
                )
                curveToRelative(5.827f, -4.5f, 2.037f, -12.48f, -0.43f, -15.116f)
                curveToRelative(-0.321f, -0.317f, -0.893f, -0.106f, -0.893f, 0.351f)
                curveToRelative(-0.036f, 0.95f, -0.322f, 2.004f, -1.072f, 2.707f)
                curveToRelative(-0.572f, -2.39f, -2.478f, -5.105f, -5.195f, -6.441f)
                curveToRelative(-0.357f, -0.176f, -0.786f, 0.105f, -0.75f, 0.492f)
                curveToRelative(0.07f, 3.27f, -2.063f, 5.352f, -3.922f, 8.059f)
                curveToRelative(-1.645f, 2.425f, -2.717f, 6.89f, 0.822f, 9.808f)
                close()
            }
        }.build()

        return _FireIcon!!
    }

@Suppress("ObjectPropertyName")
private var _FireIcon: ImageVector? = null

package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val GemeniIcon: ImageVector
    get() {
        if (_Vector != null) {
            return _Vector!!
        }
        _Vector = ImageVector.Builder(
            name = "Vector",
            defaultWidth = 30.dp,
            defaultHeight = 30.dp,
            viewportWidth = 30f,
            viewportHeight = 30f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFB7B7B7)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(26.751f, 13.408f)
                curveTo(24.486f, 12.444f, 22.426f, 11.055f, 20.683f, 9.316f)
                curveTo(18.255f, 6.883f, 16.523f, 3.845f, 15.667f, 0.517f)
                curveTo(15.629f, 0.369f, 15.544f, 0.238f, 15.423f, 0.144f)
                curveTo(15.303f, 0.051f, 15.155f, 0f, 15.002f, 0f)
                curveTo(14.85f, 0f, 14.701f, 0.051f, 14.581f, 0.144f)
                curveTo(14.461f, 0.238f, 14.375f, 0.369f, 14.337f, 0.517f)
                curveTo(13.479f, 3.845f, 11.747f, 6.883f, 9.32f, 9.316f)
                curveTo(7.577f, 11.055f, 5.517f, 12.444f, 3.251f, 13.408f)
                curveTo(2.365f, 13.79f, 1.454f, 14.097f, 0.521f, 14.333f)
                curveTo(0.373f, 14.37f, 0.24f, 14.455f, 0.146f, 14.575f)
                curveTo(0.051f, 14.696f, 0f, 14.845f, 0f, 14.998f)
                curveTo(0f, 15.151f, 0.051f, 15.3f, 0.146f, 15.42f)
                curveTo(0.24f, 15.541f, 0.373f, 15.626f, 0.521f, 15.663f)
                curveTo(1.454f, 15.897f, 2.362f, 16.204f, 3.251f, 16.586f)
                curveTo(5.517f, 17.55f, 7.577f, 18.94f, 9.32f, 20.678f)
                curveTo(11.748f, 23.111f, 13.481f, 26.15f, 14.337f, 29.479f)
                curveTo(14.374f, 29.628f, 14.459f, 29.76f, 14.58f, 29.854f)
                curveTo(14.7f, 29.949f, 14.849f, 30f, 15.002f, 30f)
                curveTo(15.155f, 30f, 15.304f, 29.949f, 15.425f, 29.854f)
                curveTo(15.545f, 29.76f, 15.63f, 29.628f, 15.667f, 29.479f)
                curveTo(15.901f, 28.545f, 16.208f, 27.636f, 16.59f, 26.747f)
                curveTo(17.555f, 24.482f, 18.944f, 22.422f, 20.683f, 20.678f)
                curveTo(23.116f, 18.251f, 26.154f, 16.519f, 29.483f, 15.663f)
                curveTo(29.631f, 15.625f, 29.762f, 15.539f, 29.855f, 15.419f)
                curveTo(29.949f, 15.299f, 30f, 15.15f, 30f, 14.998f)
                curveTo(30f, 14.845f, 29.949f, 14.697f, 29.855f, 14.577f)
                curveTo(29.762f, 14.456f, 29.631f, 14.371f, 29.483f, 14.333f)
                curveTo(28.549f, 14.098f, 27.636f, 13.789f, 26.751f, 13.408f)
                close()
            }
        }.build()

        return _Vector!!
    }

@Suppress("ObjectPropertyName")
private var _Vector: ImageVector? = null

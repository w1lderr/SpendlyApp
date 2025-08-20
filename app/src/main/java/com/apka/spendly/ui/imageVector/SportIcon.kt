package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val SportIcon: ImageVector
    get() {
        if (_Sportandfitness != null) {
            return _Sportandfitness!!
        }
        _Sportandfitness = ImageVector.Builder(
            name = "Sportandfitness",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(fill = SolidColor(Color(0xFFE3E3E3))) {
                moveToRelative(536f, 876f)
                lineToRelative(-56f, -56f)
                lineToRelative(142f, -142f)
                lineToRelative(-340f, -340f)
                lineToRelative(-142f, 142f)
                lineToRelative(-56f, -56f)
                lineToRelative(56f, -58f)
                lineToRelative(-56f, -56f)
                lineToRelative(84f, -84f)
                lineToRelative(-56f, -58f)
                lineToRelative(56f, -56f)
                lineToRelative(58f, 56f)
                lineToRelative(84f, -84f)
                lineToRelative(56f, 56f)
                lineToRelative(58f, -56f)
                lineToRelative(56f, 56f)
                lineToRelative(-142f, 142f)
                lineToRelative(340f, 340f)
                lineToRelative(142f, -142f)
                lineToRelative(56f, 56f)
                lineToRelative(-56f, 58f)
                lineToRelative(56f, 56f)
                lineToRelative(-84f, 84f)
                lineToRelative(56f, 58f)
                lineToRelative(-56f, 56f)
                lineToRelative(-58f, -56f)
                lineToRelative(-84f, 84f)
                lineToRelative(-56f, -56f)
                lineToRelative(-58f, 56f)
                close()
            }
        }.build()

        return _Sportandfitness!!
    }

@Suppress("ObjectPropertyName")
private var _Sportandfitness: ImageVector? = null

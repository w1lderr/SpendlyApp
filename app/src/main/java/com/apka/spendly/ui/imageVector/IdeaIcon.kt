package com.apka.spendly.ui.imageVector

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val IdeaIcon: ImageVector
    get() {
        if (_IdeaIcon != null) {
            return _IdeaIcon!!
        }
        _IdeaIcon = ImageVector.Builder(
            name = "IdeaIcon",
            defaultWidth = 50.dp,
            defaultHeight = 50.dp,
            viewportWidth = 50f,
            viewportHeight = 50f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(17.099f, 33.235f)
                lineTo(17.583f, 35.417f)
                horizontalLineTo(32.417f)
                lineTo(32.901f, 33.235f)
                curveTo(33.229f, 31.759f, 33.93f, 30.369f, 35.027f, 29.328f)
                curveTo(37.911f, 26.594f, 39.583f, 22.775f, 39.583f, 18.75f)
                curveTo(39.583f, 10.71f, 33.039f, 4.193f, 25f, 4.19f)
                curveTo(16.962f, 4.193f, 10.417f, 10.71f, 10.417f, 18.75f)
                curveTo(10.417f, 22.775f, 12.089f, 26.594f, 14.972f, 29.328f)
                curveTo(16.07f, 30.369f, 16.771f, 31.759f, 17.099f, 33.235f)
                close()
                moveTo(18.278f, 38.542f)
                lineTo(19.264f, 42.978f)
                curveTo(19.634f, 44.647f, 21.115f, 45.833f, 22.823f, 45.833f)
                horizontalLineTo(27.177f)
                curveTo(28.885f, 45.833f, 30.366f, 44.647f, 30.736f, 42.978f)
                lineTo(31.722f, 38.542f)
                horizontalLineTo(18.278f)
                close()
            }
        }.build()

        return _IdeaIcon!!
    }

@Suppress("ObjectPropertyName")
private var _IdeaIcon: ImageVector? = null
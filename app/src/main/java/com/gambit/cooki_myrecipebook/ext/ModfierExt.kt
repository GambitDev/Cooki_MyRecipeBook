package com.gambit.cooki_myrecipebook.ext

import android.util.LayoutDirection
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.core.text.layoutDirection
import java.util.*

fun Modifier.mirrorOnLtr(): Modifier {
    return if (Locale.getDefault().layoutDirection == LayoutDirection.LTR)
        scale(scaleX = -1f, scaleY = 1f)
    else
        this
}

fun Modifier.mirrorOnRtl(): Modifier {
    return if (Locale.getDefault().layoutDirection == LayoutDirection.RTL)
        scale(scaleX = -1f, scaleY = 1f)
    else
        this
}

fun Modifier.withOutlineBorder(): Modifier = composed {
    border(
        1.dp,
        MaterialTheme.colorScheme.outline,
        MaterialTheme.shapes.extraSmall
    )
}
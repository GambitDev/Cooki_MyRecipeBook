package com.gambit.cooki_myrecipebook.ext

import android.util.LayoutDirection
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.core.text.layoutDirection
import java.util.*

fun Modifier.mirror(): Modifier {
    return if (Locale.getDefault().layoutDirection == LayoutDirection.LTR)
        scale(scaleX = -1f, scaleY = 1f)
    else
        this
}
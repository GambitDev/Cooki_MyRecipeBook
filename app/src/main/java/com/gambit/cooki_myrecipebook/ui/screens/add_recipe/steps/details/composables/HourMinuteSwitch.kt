package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.details.composables

import android.graphics.Paint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.R

@Composable
fun HourMinuteSwitch(
    modifier: Modifier = Modifier,
    selection: TimeUnit,
    onSelectionChanged: () -> Unit,
    width: Dp = 150.dp,
    height: Dp = 30.dp,
    cornerRadius: Dp = 8.dp
) {
    val thumbWidth = width / 2

    // To move thumb, we need to calculate the position (along x axis)
    val animatePosition = animateFloatAsState(
        targetValue = if (selection == TimeUnit.Hours)
            with(LocalDensity.current) { (width - thumbWidth).toPx() }
        else 0f
    )

    val trackColor = MaterialTheme.colorScheme.primary
    val thumbColor = MaterialTheme.colorScheme.secondary

    val hoursText = stringResource(id = R.string.hours)
    val minutesText = stringResource(id = R.string.minutes)

    val textColor = MaterialTheme.colorScheme.onPrimary.toArgb()

    Canvas(
        modifier = modifier
            .size(width, height)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        // This is called when the user taps on the canvas
                        onSelectionChanged()
                    }
                )
            }
    ) {
        // Track
        drawRoundRect(
            color = trackColor,
            cornerRadius = CornerRadius(x = cornerRadius.toPx(), y = cornerRadius.toPx())
        )

        // Thumb
        drawRoundRect(
            color = thumbColor,
            cornerRadius = CornerRadius(x = cornerRadius.toPx(), y = cornerRadius.toPx()),
            size = Size(width = thumbWidth.toPx(), height = height.toPx()),
            topLeft = Offset(
                x = animatePosition.value,
                y = 0f
            )
        )

        drawContext.canvas.nativeCanvas.apply {
            drawText(
                minutesText,
                size.width / 4,
                size.height / 2 + size.height / 6,
                Paint().apply {
                    textSize = size.height / 2
                    textAlign = Paint.Align.CENTER
                    color = textColor
                }
            )

            drawText(
                hoursText,
                size.width * 3 / 4,
                size.height / 2 + size.height / 6,
                Paint().apply {
                    textSize = size.height / 2
                    textAlign = Paint.Align.CENTER
                    color = textColor
                }
            )
        }
    }
}

enum class TimeUnit {
    Hours, Minutes;

    operator fun not() =
        if (this == Hours) Minutes
        else Hours
}
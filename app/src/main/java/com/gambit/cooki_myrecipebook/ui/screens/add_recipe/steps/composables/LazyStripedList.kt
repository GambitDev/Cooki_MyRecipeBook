package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.composables

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.RectF
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.ext.isEven
import com.gambit.cooki_myrecipebook.ext.withOutlineBorder
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables.lazy_list.LazyColumn
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables.lazy_list.LazyListScope
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables.lazy_list.rememberLazyListState

@Composable
fun LazyStripedList(
    modifier: Modifier = Modifier,
    itemCount: Int,
    content: LazyListScope.() -> Unit
) {
    val lazyListState = rememberLazyListState()
    val firstVisibleIndex = remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex
        }
    }
    val totalVisibleItems = remember {
        derivedStateOf {
            lazyListState.layoutInfo.visibleItemsInfo.size
        }
    }
    BoxWithConstraints(
        modifier = modifier
            .padding(top = 8.dp) // this is used to simulate OutlinedTextField's top padding
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraSmall)
    ) {
        ListBg(
            modifier = Modifier.withOutlineBorder(),
            firstVisibleIndex = firstVisibleIndex.value,
            totalVisibleItems = totalVisibleItems.value,
            itemsCount = itemCount,
            maxHeight = maxHeight,
            offset = lazyListState.scrollPosition.scrollOffset
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = lazyListState
        ) {
            content()
        }
    }
}

@Composable
private fun ListBg(
    modifier: Modifier = Modifier,
    firstVisibleIndex: Int,
    totalVisibleItems: Int,
    itemsCount: Int,
    maxHeight: Dp,
    offset: Int
) {
    val hasNoScroll = itemsCount <= totalVisibleItems
    val totalHeight = if (hasNoScroll) maxHeight else maxHeight +
            (LazyStripedListConstants.RowHeight * 2)
    val darkColor = MaterialTheme.colorScheme.background
    val lightColor = MaterialTheme.colorScheme.tertiary
    Box(
        modifier = modifier
            .wrapContentSize()
    ) {
        Box(
            Modifier
                .wrapContentHeight(unbounded = true, align = Alignment.Top)
                .offset { IntOffset(x = 0, y = -offset) }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(totalHeight)
                    .drawBehind {
                        val paint = Paint()
                            .asFrameworkPaint()
                            .apply {
                                isAntiAlias = true
                                shader = ImageShader(
                                    getListBgPattern(
                                        firstVisibleIndex = firstVisibleIndex,
                                        darkColor = darkColor,
                                        lightColor = lightColor
                                    ),
                                    TileMode.Repeated,
                                    TileMode.Repeated
                                )
                            }

                        drawIntoCanvas {
                            it.nativeCanvas.drawPaint(paint)
                        }
                        paint.reset()
                    }
            )
        }
    }
}

private fun DrawScope.getListBgPattern(
    firstVisibleIndex: Int,
    darkColor: Color,
    lightColor: Color
): ImageBitmap {
    val resultPattern = Bitmap.createBitmap(
        1.dp.roundToPx(),
        (LazyStripedListConstants.RowHeight * 2).roundToPx(),
        Bitmap.Config.ARGB_8888
    )
    val darkPaint = Paint()
        .asFrameworkPaint()
        .apply {
            color = darkColor.toArgb()
        }
    val darkRect = RectF(
        0f, 0f,
        1.dp.toPx(),
        LazyStripedListConstants.RowHeight.toPx()
    )
    val lightPaint = Paint()
        .asFrameworkPaint()
        .apply {
            color = lightColor.toArgb()
        }
    val lightRect = RectF(
        0f,
        LazyStripedListConstants.RowHeight.toPx(),
        1.dp.toPx(),
        (LazyStripedListConstants.RowHeight * 2).toPx()
    )
    Canvas(resultPattern)
        .apply {
            drawRect(darkRect, darkPaint)
            drawRect(lightRect, lightPaint)
        }

    return if (firstVisibleIndex.isEven()) resultPattern.asImageBitmap()
    else {
        val matrix = Matrix()
        matrix.postRotate(180f)
        Bitmap.createBitmap(
            resultPattern,
            0, 0,
            resultPattern.width,
            resultPattern.height,
            matrix,
            true
        ).asImageBitmap()
    }
}

object LazyStripedListConstants {
    val RowHeight = 40.dp
}
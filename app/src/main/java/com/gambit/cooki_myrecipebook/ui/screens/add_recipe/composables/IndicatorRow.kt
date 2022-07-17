package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.R
import com.gambit.cooki_myrecipebook.ext.mirrorOnRtl
import com.gambit.cooki_myrecipebook.ui.theme.CookiMyRecipeBookTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun IndicatorRow(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val scope = rememberCoroutineScope()
        IconButton(
            onClick = {
                val current = pagerState.currentPage
                if (current > 0)
                    scope.launch {
                        pagerState.animateScrollToPage(current - 1)
                    }
            },
            enabled = pagerState.currentPage > 0
        ) {
            Icon(
                modifier = Modifier
                    .size(14.dp)
                    .mirrorOnRtl(),
                imageVector = Icons.Default.ArrowBackIos,
                contentDescription = stringResource(id = R.string.back)
            )
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            inactiveColor = MaterialTheme.colorScheme.primary,
            activeColor = LocalContentColor.current,
            indicatorWidth = 13.dp
        )
        IconButton(
            onClick = {
                val current = pagerState.currentPage
                if (current < pagerState.pageCount - 1)
                    scope.launch {
                        pagerState.animateScrollToPage(current + 1)
                    }
            },
            enabled = pagerState.currentPage < pagerState.pageCount - 1
        ) {
            Icon(
                modifier = Modifier
                    .size(14.dp)
                    .mirrorOnRtl(),
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = stringResource(id = R.string.forward)
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun LightIndicatorRowPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            val pagerState = rememberPagerState()
            HorizontalPager(count = 5, state = pagerState) { }
            IndicatorRow(pagerState = pagerState)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun DarkIndicatorRowPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            val pagerState = rememberPagerState()
            HorizontalPager(count = 5, state = pagerState) { }
            IndicatorRow(pagerState = pagerState)
        }
    }
}
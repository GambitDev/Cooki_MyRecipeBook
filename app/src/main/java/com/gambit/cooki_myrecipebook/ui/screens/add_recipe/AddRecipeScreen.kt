package com.gambit.cooki_myrecipebook.ui.screens.add_recipe

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.R
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables.IndicatorRow
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables.PagerContent
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.*
import com.gambit.cooki_myrecipebook.ui.theme.CookiMyRecipeBookTheme
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AddRecipeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val pagerState = rememberPagerState()

        HorizontalPager(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            count = AddRecipeStep.count(),
            state = pagerState
        ) { pageNumber ->
            PagerContent(pageNumber = pageNumber)
        }

        IndicatorRow(
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 64.dp),
            pagerState = pagerState
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LightAddRecipeScreenPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            AddRecipeScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DarkAddRecipeScreenPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            AddRecipeScreen()
        }
    }
}
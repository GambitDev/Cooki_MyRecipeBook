package com.gambit.cooki_myrecipebook.ui.screens.add_recipe

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.R
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
            count = AddRecipeStep.values().size,
            state = pagerState
        ) { pageNumber ->
            when (AddRecipeStep.values()[pageNumber]) {
                AddRecipeStep.RecipeDetails -> RecipeDetailsStep()
                AddRecipeStep.Ingredients -> IngredientsStep()
                AddRecipeStep.Instructions -> InstructionsStep()
                AddRecipeStep.Metadata -> RecipeMetadataStep()
                AddRecipeStep.Images -> RecipeImagesStep()
            }
        }

        IndicatorRow(
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 64.dp),
            pagerState = pagerState
        )
    }
}

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
                modifier = Modifier.size(14.dp),
                imageVector = Icons.Default.ArrowBackIos,
                contentDescription = stringResource(id = R.string.back)
            )
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            inactiveColor = MaterialTheme.colorScheme.primary,
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
                modifier = Modifier.size(14.dp),
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = stringResource(id = R.string.back)
            )
        }
    }
}

enum class AddRecipeStep {
    RecipeDetails, Ingredients, Instructions, Metadata, Images
}

@Composable
fun RecipeDetailsStep(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "RecipeDetailsStep")
    }
}

@Composable
fun IngredientsStep(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "IngredientsStep")
    }
}

@Composable
fun InstructionsStep(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "InstructionsStep")
    }
}

@Composable
fun RecipeMetadataStep(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "RecipeMetadataStep")
    }
}

@Composable
fun RecipeImagesStep(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "RecipeImagesStep")
    }
}
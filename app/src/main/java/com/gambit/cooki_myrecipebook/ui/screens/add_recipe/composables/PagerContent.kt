package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables

import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.*
import com.gambit.cooki_myrecipebook.ui.theme.CookiMyRecipeBookTheme

@Composable
fun PagerContent(
    modifier: Modifier = Modifier,
    pageNumber: Int
) {
    when (AddRecipeStep.getStepAt(pageNumber)) {
        AddRecipeStep.Details -> RecipeDetailsStep(
            modifier = modifier
        )
        AddRecipeStep.Ingredients -> IngredientsStep(
            modifier = modifier
        )
        AddRecipeStep.Instructions -> InstructionsStep(
            modifier = modifier
        )
        AddRecipeStep.Metadata -> RecipeMetadataStep(
            modifier = modifier
        )
        AddRecipeStep.Images -> RecipeImagesStep(
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LightPagerContentPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            PagerContent(
                pageNumber = 0
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DarkPagerContentPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            PagerContent(
                pageNumber = 0
            )
        }
    }
}
package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.*
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.details.RecipeDetailsStep
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.ingredients.IngredientsStep
import com.gambit.cooki_myrecipebook.ui.theme.CookiMyRecipeBookTheme

@Composable
fun PagerContent(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PagePadding,
    pageNumber: Int
) {
    when (AddRecipeStep.getStepAt(pageNumber)) {
        AddRecipeStep.Details ->
            RecipeDetailsStep(
                modifier = modifier,
                contentPadding = contentPadding
            )
        AddRecipeStep.Ingredients ->
            IngredientsStep(
                modifier = modifier,
                contentPadding = contentPadding
            )
        AddRecipeStep.Instructions ->
            InstructionsStep(
                modifier = modifier,
                contentPadding = contentPadding
            )
        AddRecipeStep.Metadata ->
            RecipeMetadataStep(
                modifier = modifier,
                contentPadding = contentPadding
            )
        AddRecipeStep.Images ->
            RecipeImagesStep(
                modifier = modifier,
                contentPadding = contentPadding
            )
    }
}

private val PagePadding =
    PaddingValues(vertical = 18.dp, horizontal = 40.dp)

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
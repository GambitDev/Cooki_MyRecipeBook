package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.ingredients

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.R
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables.lazy_list.items
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.composables.LazyStripedList
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.composables.LazyStripedListConstants
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.composables.StepTitle

@Composable
fun IngredientsStep(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 0.dp)
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(contentPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        StepTitle(stringRes = R.string.recipe_details_step_title)
        val list = generateList(100)
        LazyStripedList(
            modifier = Modifier.weight(1f),
            itemCount = list.size
        ) {
            items(list) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(LazyStripedListConstants.RowHeight),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = it.toString())
                }
            }
        }
    }
}

fun generateList(size: Int) = List(size) { it }
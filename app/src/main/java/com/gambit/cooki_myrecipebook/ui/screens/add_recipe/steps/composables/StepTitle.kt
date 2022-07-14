package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.composables

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun StepTitle(
    modifier: Modifier = Modifier,
    @StringRes stringRes: Int
) {
    Text(
        modifier = modifier,
        text = stringResource(id = stringRes),
        style = MaterialTheme.typography.titleMedium
            .copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
    )
}
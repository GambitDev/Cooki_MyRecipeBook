package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.details.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.R
import com.gambit.cooki_myrecipebook.ext.isOnlyNumericCharacters

@Composable
fun CookingTimeField(
    modifier: Modifier = Modifier,
    cookingTimeState: TextFieldValue,
    onCookingTimeStateChanged: (TextFieldValue) -> Unit,
    selectionTypeState: TimeUnit,
    onSelectionTypeStateChanged: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(top = 8.dp) // this is used to simulate OutlinedTextField's top padding
            .fillMaxWidth()
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                MaterialTheme.shapes.extraSmall
            )
            .padding(16.dp), // this is for padding inside of column
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.add_recipe_cooking_time_label),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BorderlessTextField(
                modifier = Modifier.weight(1f),
                cookingTimeState = cookingTimeState,
                onCookingTimeStateChanged = onCookingTimeStateChanged
            )
            HourMinuteSwitch(
                modifier = modifier,
                selection = selectionTypeState,
                onSelectionChanged = onSelectionTypeStateChanged
            )
        }
    }
}

@Composable
fun BorderlessTextField(
    modifier: Modifier = Modifier,
    cookingTimeState: TextFieldValue,
    onCookingTimeStateChanged: (TextFieldValue) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = cookingTimeState,
        onValueChange = {
            if (it.text.isOnlyNumericCharacters())
                onCookingTimeStateChanged(it)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default
            .copy(keyboardType = KeyboardType.Number),
        decorationBox = { innerTextField ->
            if (cookingTimeState.text.isEmpty()) {
                Text(
                    text = stringResource(R.string.add_recipe_cooking_time_placeholder),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                        .copy(alpha = 0.5f)
                )
            }
            innerTextField()
        }
    )
}
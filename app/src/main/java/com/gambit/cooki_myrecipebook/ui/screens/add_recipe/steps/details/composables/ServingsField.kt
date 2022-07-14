package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.details.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.gambit.cooki_myrecipebook.R
import com.gambit.cooki_myrecipebook.ext.isOnlyNumericCharacters
import com.gambit.cooki_myrecipebook.ui.theme.CookiMyRecipeBookTheme

@Composable
fun ServingsField(
    modifier: Modifier = Modifier,
    fieldValue: TextFieldValue,
    onFieldValueChanged: (TextFieldValue) -> Unit
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = fieldValue,
        onValueChange = {
            // only allow numbers
            if (it.text.isOnlyNumericCharacters()) {
                onFieldValueChanged(it)
            }
        },
        keyboardOptions = KeyboardOptions.Default
            .copy(keyboardType = KeyboardType.Number),
        label = {
            Text(
                text = stringResource(
                    id = R.string.add_recipe_servings_field_label
                )
            )
        },
        singleLine = true
    )
}

@Preview
@Composable
fun LightServingsFieldPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            ServingsField(
                fieldValue = TextFieldValue(),
                onFieldValueChanged = {}
            )
        }
    }
}

@Preview
@Composable
fun DarkServingsFieldPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            ServingsField(
                fieldValue = TextFieldValue(),
                onFieldValueChanged = {}
            )
        }
    }
}
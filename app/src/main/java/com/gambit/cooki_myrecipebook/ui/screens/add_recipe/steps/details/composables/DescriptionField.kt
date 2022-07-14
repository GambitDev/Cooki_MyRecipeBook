package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.details.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.R
import com.gambit.cooki_myrecipebook.ui.theme.CookiMyRecipeBookTheme

@Composable
fun DescriptionField(
    modifier: Modifier = Modifier,
    fieldValue: TextFieldValue,
    onFieldValueChanged: (TextFieldValue) -> Unit
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp),
        value = fieldValue,
        onValueChange = onFieldValueChanged,
        label = {
            Text(
                text = stringResource(
                    id = R.string.add_recipe_desc_field_label
                )
            )
        }
    )
}

@Preview
@Composable
fun LightDescriptionFieldPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            DescriptionField(
                fieldValue = TextFieldValue(),
                onFieldValueChanged = {}
            )
        }
    }
}

@Preview
@Composable
fun DarkDescriptionFieldPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            DescriptionField(
                fieldValue = TextFieldValue(),
                onFieldValueChanged = {}
            )
        }
    }
}
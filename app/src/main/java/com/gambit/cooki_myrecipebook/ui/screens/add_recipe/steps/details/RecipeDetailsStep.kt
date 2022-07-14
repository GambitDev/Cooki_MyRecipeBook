package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.R
import com.gambit.cooki_myrecipebook.data.local_data.entities.enums.SkillLevel
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.composables.StepTitle
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.details.composables.*
import com.gambit.cooki_myrecipebook.ui.theme.CookiMyRecipeBookTheme

@Composable
fun RecipeDetailsStep(
    modifier: Modifier = Modifier
) {
    var titleTextFieldValue by remember {
        mutableStateOf(TextFieldValue())
    }
    var descriptionTextFieldValue by remember {
        mutableStateOf(TextFieldValue())
    }
    var servingsTextFieldValue by remember {
        mutableStateOf(TextFieldValue())
    }
    var cookingTimeUnitTypeState by remember {
        mutableStateOf(TimeUnit.Hours)
    }
    var cookingTimeFieldValue by remember {
        mutableStateOf(TextFieldValue())
    }
    var selectedSkillLevel by remember {
        mutableStateOf(SkillLevel.NoSkill)
    }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        StepTitle(stringRes = R.string.recipe_details_step_title)
        TitleField(
            fieldValue = titleTextFieldValue,
            onFieldValueChanged = { titleTextFieldValue = it }
        )
        DescriptionField(
            fieldValue = descriptionTextFieldValue,
            onFieldValueChanged = { descriptionTextFieldValue = it }
        )
        ServingsField(
            fieldValue = servingsTextFieldValue,
            onFieldValueChanged = { servingsTextFieldValue = it }
        )
        CookingTimeField(
            cookingTimeState = cookingTimeFieldValue,
            onCookingTimeStateChanged = { cookingTimeFieldValue = it },
            selectionTypeState = cookingTimeUnitTypeState,
            onSelectionTypeStateChanged = {
                cookingTimeUnitTypeState = !cookingTimeUnitTypeState
            }
        )
        SkillLevelSelector(
            selectedSkillLevel = selectedSkillLevel,
            onSelectedSkillLevelChanged = { selectedSkillLevel = it }
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
            RecipeDetailsStep()
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
            RecipeDetailsStep()
        }
    }
}
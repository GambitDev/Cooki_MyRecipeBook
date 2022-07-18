package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.R
import com.gambit.cooki_myrecipebook.data.local_data.entities.enums.SkillLevel
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.composables.StepTitle
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.details.composables.*
import com.gambit.cooki_myrecipebook.ui.theme.CookiMyRecipeBookTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RecipeDetailsStep(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 0.dp)
) {
    val stepState = rememberSaveable(
        saver = RecipeDetailsStepStateSaver()
    ) { RecipeDetailsStepStateHolder() }
    val scrollState = rememberScrollState()
    val keyboardController =
        LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(contentPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        StepTitle(stringRes = R.string.recipe_details_step_title)
        TitleField(
            fieldValue = stepState.titleTextFieldValue,
            onFieldValueChanged = { stepState.titleTextFieldValue = it },
            closeKeyboard = { keyboardController?.hide() }
        )
        DescriptionField(
            fieldValue = stepState.descriptionTextFieldValue,
            onFieldValueChanged = { stepState.descriptionTextFieldValue = it },
            closeKeyboard = { keyboardController?.hide() }
        )
        ServingsField(
            fieldValue = stepState.servingsTextFieldValue,
            onFieldValueChanged = { stepState.servingsTextFieldValue = it },
            closeKeyboard = { keyboardController?.hide() }
        )
        CookingTimeField(
            cookingTimeState = stepState.cookingTimeFieldValue,
            onCookingTimeStateChanged = { stepState.cookingTimeFieldValue = it },
            selectionTypeState = stepState.cookingTimeUnitTypeState,
            onSelectionTypeStateChanged = {
                stepState.cookingTimeUnitTypeState = !stepState.cookingTimeUnitTypeState
            },
            closeKeyboard = { keyboardController?.hide() }
        )
        SkillLevelSelector(
            selectedSkillLevel = stepState.selectedSkillLevel,
            onSelectedSkillLevelChanged = { stepState.selectedSkillLevel = it }
        )
    }
}

class RecipeDetailsStepStateHolder {
    var titleTextFieldValue by mutableStateOf(TextFieldValue())
    var descriptionTextFieldValue by mutableStateOf(TextFieldValue())
    var servingsTextFieldValue by mutableStateOf(TextFieldValue())
    var cookingTimeUnitTypeState by mutableStateOf(TimeUnit.Hours)
    var cookingTimeFieldValue by mutableStateOf(TextFieldValue())
    var selectedSkillLevel by mutableStateOf(SkillLevel.NoSkill)
}

class RecipeDetailsStepStateSaver: Saver<RecipeDetailsStepStateHolder, List<Any>> {
    override fun restore(value: List<Any>) =
        RecipeDetailsStepStateHolder().apply {
            titleTextFieldValue = value[0] as TextFieldValue
            descriptionTextFieldValue = value[1] as TextFieldValue
            servingsTextFieldValue = value[2] as TextFieldValue
            cookingTimeUnitTypeState = value[3] as TimeUnit
            cookingTimeFieldValue = value[4] as TextFieldValue
            selectedSkillLevel = value[5] as SkillLevel
        }

    override fun SaverScope.save(value: RecipeDetailsStepStateHolder) =
        listOf(
            value.titleTextFieldValue,
            value.descriptionTextFieldValue,
            value.servingsTextFieldValue,
            value.cookingTimeUnitTypeState,
            value.cookingTimeFieldValue,
            value.selectedSkillLevel
        )
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
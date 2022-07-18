package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps.details.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gambit.cooki_myrecipebook.R
import com.gambit.cooki_myrecipebook.data.local_data.entities.enums.SkillLevel
import com.gambit.cooki_myrecipebook.ext.withOutlineBorder

@Composable
fun SkillLevelSelector(
    modifier: Modifier = Modifier,
    selectedSkillLevel: SkillLevel,
    onSelectedSkillLevelChanged: (SkillLevel) -> Unit
) {
    Row(
        modifier = modifier
            .padding(top = 8.dp) // this is used to simulate OutlinedTextField's top padding
            .fillMaxWidth()
            .withOutlineBorder()
            .padding(16.dp), // this is for padding inside of row
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.add_recipe_skill_level_label),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        LevelIndicatorRow(
            selectedLevel = selectedSkillLevel,
            onSelectedLevelChanged = onSelectedSkillLevelChanged
        )
    }
}

@Composable
fun LevelIndicatorRow(
    modifier: Modifier = Modifier,
    selectedLevel: SkillLevel,
    onSelectedLevelChanged: (SkillLevel) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SkillLevel.levelRange().forEach {
            LevelIndicator(
                selected = it <= selectedLevel.getHumanReadableIndex(),
                indicatorNumber = it,
                onIndicatorClicked = { indicatorNumber ->
                    onSelectedLevelChanged(
                        SkillLevel.getLevelFromHumanReadableIndex(
                            indicatorNumber
                        )
                    )
                }
            )
        }
    }
}

@Composable
fun LevelIndicator(
    modifier: Modifier = Modifier,
    selected: Boolean,
    indicatorNumber: Int,
    onIndicatorClicked: (Int) -> Unit
) {
    Box(
        modifier = modifier
            .size(16.dp)
            .background(
                color = if (selected)
                    MaterialTheme.colorScheme.secondary
                else
                    MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.extraSmall
            )
            .clickable { onIndicatorClicked(indicatorNumber) },
        contentAlignment = Alignment.Center
    ) {
        if (indicatorNumber == 1 || indicatorNumber == 5)
            Text(
                text = indicatorNumber.toString(),
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 12.sp
            )
    }
}
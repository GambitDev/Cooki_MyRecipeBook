package com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["recipeId", "name"])
data class RecipeAndIngredientCrossRef(
    val recipeId: Int,
    @ColumnInfo(index = true)
    val name: String
)
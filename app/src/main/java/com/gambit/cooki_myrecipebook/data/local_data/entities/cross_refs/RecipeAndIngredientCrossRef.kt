package com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs

import androidx.room.Entity

@Entity(primaryKeys = ["recipeId", "ingredientId"])
data class RecipeAndIngredientCrossRef(
    val recipeId: Int,
    val ingredientId: String
)
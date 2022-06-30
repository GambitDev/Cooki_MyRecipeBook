package com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs

import androidx.room.Entity

@Entity(primaryKeys = ["recipeId, categoryId"])
data class RecipeAndCategoryCrossRef(
    val recipeId: Int,
    val categoryId: String
)
package com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs

import androidx.room.Entity

@Entity(primaryKeys = ["recipeId", "tagId"])
data class RecipeAndTagCrossRef(
    val recipeId: Int,
    val tagId: String
)
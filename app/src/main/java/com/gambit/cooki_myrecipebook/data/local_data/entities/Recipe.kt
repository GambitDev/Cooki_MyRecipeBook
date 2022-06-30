package com.gambit.cooki_myrecipebook.data.local_data.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndCategoryCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndIngredientCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndTagCrossRef

data class Recipe(
    @Embedded
    val recipeEntity : RecipeEntity,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "ingredientId",
        associateBy = Junction(RecipeAndIngredientCrossRef::class)
    )
    val ingredients: List<Ingredient>,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "tagId",
        associateBy = Junction(RecipeAndTagCrossRef::class)
    )
    val tags: List<Tag>,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "categoryId",
        associateBy = Junction(RecipeAndCategoryCrossRef::class)
    )
    val category: Category
)

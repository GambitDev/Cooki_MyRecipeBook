package com.gambit.cooki_myrecipebook.data.models

import com.gambit.cooki_myrecipebook.data.local_data.entities.Category
import com.gambit.cooki_myrecipebook.data.local_data.entities.Ingredient
import com.gambit.cooki_myrecipebook.data.local_data.entities.RecipeEntity
import com.gambit.cooki_myrecipebook.data.local_data.entities.Tag
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndCategoryCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndIngredientCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndTagCrossRef

data class RawRecipeData(
    val recipeEntity: RecipeEntity,
    val tagList: List<Tag>,
    val ingredientList: List<Ingredient>,
    val category: Category
) {
    val tagCrossRefs =
        tagList.map { RecipeAndTagCrossRef(recipeEntity.recipeId, it.name) }
    val ingredientCrossRefs =
        ingredientList.map { RecipeAndIngredientCrossRef(recipeEntity.recipeId, it.name) }
    val categoryCrossRef =
        RecipeAndCategoryCrossRef(recipeEntity.recipeId, category.name)
}
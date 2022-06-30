package com.gambit.cooki_myrecipebook.data

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
        tagList.map { RecipeAndTagCrossRef(recipeEntity.id, it.name) }
    val ingredientCrossRefs =
        ingredientList.map { RecipeAndIngredientCrossRef(recipeEntity.id, it.name) }
    val categoryCrossRef =
        RecipeAndCategoryCrossRef(recipeEntity.id, category.name)
}
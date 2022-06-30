package com.gambit.cooki_myrecipebook.data.repositories

import com.gambit.cooki_myrecipebook.data.RawRecipeData
import com.gambit.cooki_myrecipebook.data.local_data.LocalDataSource

class RecipeRepository(override val localDataSource: LocalDataSource) : Repository {
    override suspend fun createRecipe(recipeData: RawRecipeData) {
        with(localDataSource) {
            insertRecipe(recipeData.recipeEntity)
            insertTags(recipeData.tagList)
            insertIngredients(recipeData.ingredientList)
            insertCategory(recipeData.category)
            insertRecipeAndTagCrossRefs(recipeData.tagCrossRefs)
            insertRecipeAndIngredientCrossRefs(recipeData.ingredientCrossRefs)
            insertRecipeAndCategoryCrossRef(recipeData.categoryCrossRef)
        }
    }
}
package com.gambit.cooki_myrecipebook.data.repositories

import com.gambit.cooki_myrecipebook.data.RawRecipeData
import com.gambit.cooki_myrecipebook.data.local_data.LocalDataSource
import com.gambit.cooki_myrecipebook.data.local_data.entities.Category
import com.gambit.cooki_myrecipebook.data.local_data.entities.Ingredient
import com.gambit.cooki_myrecipebook.data.local_data.entities.RecipeEntity
import com.gambit.cooki_myrecipebook.data.local_data.entities.Tag

interface Repository {
    val localDataSource: LocalDataSource

    suspend fun createRecipe(recipeData: RawRecipeData)
}
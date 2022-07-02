package com.gambit.cooki_myrecipebook.data.repositories

import com.gambit.cooki_myrecipebook.data.models.RawRecipeData
import com.gambit.cooki_myrecipebook.data.local_data.LocalDataSource

interface Repository {
    val localDataSource: LocalDataSource

    suspend fun createRecipe(recipeData: RawRecipeData)
}
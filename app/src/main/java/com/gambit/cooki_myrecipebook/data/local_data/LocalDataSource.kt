package com.gambit.cooki_myrecipebook.data.local_data

import com.gambit.cooki_myrecipebook.data.local_data.daos.*
import com.gambit.cooki_myrecipebook.data.local_data.entities.Category
import com.gambit.cooki_myrecipebook.data.local_data.entities.Ingredient
import com.gambit.cooki_myrecipebook.data.local_data.entities.RecipeEntity
import com.gambit.cooki_myrecipebook.data.local_data.entities.Tag
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndCategoryCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndIngredientCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndTagCrossRef

interface LocalDataSource {
    val daoHelper: DaoHelper

    suspend fun insertRecipe(recipeEntity: RecipeEntity)
    suspend fun insertTags(tagList: List<Tag>)
    suspend fun insertCategory(category: Category)
    suspend fun insertIngredients(ingredientList: List<Ingredient>)
    suspend fun insertRecipeAndTagCrossRefs(crossRefs: List<RecipeAndTagCrossRef>)
    suspend fun insertRecipeAndIngredientCrossRefs(crossRefs: List<RecipeAndIngredientCrossRef>)
    suspend fun insertRecipeAndCategoryCrossRef(crossRef: RecipeAndCategoryCrossRef)
}
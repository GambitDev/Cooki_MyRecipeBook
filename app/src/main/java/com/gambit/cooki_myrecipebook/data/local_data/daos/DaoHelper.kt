package com.gambit.cooki_myrecipebook.data.local_data.daos

data class DaoHelper(
    val recipeDao: RecipeDao,
    val tagDao: TagDao,
    val categoryDao: CategoryDao,
    val ingredientDao: IngredientDao
)

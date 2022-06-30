package com.gambit.cooki_myrecipebook.data.local_data

import com.gambit.cooki_myrecipebook.data.local_data.daos.DaoHelper
import com.gambit.cooki_myrecipebook.data.local_data.entities.Category
import com.gambit.cooki_myrecipebook.data.local_data.entities.Ingredient
import com.gambit.cooki_myrecipebook.data.local_data.entities.RecipeEntity
import com.gambit.cooki_myrecipebook.data.local_data.entities.Tag
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndCategoryCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndIngredientCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndTagCrossRef

class RoomDataSource(override val daoHelper: DaoHelper) : LocalDataSource {
    override suspend fun insertRecipe(recipeEntity: RecipeEntity) =
        daoHelper.recipeDao.insertRecipe(recipeEntity)

    override suspend fun insertTags(tagList: List<Tag>) =
        tagList.forEach { daoHelper.tagDao.insertTag(it) }

    override suspend fun insertCategory(category: Category) =
        daoHelper.categoryDao.insertCategory(category)

    override suspend fun insertIngredients(ingredientList: List<Ingredient>) =
        ingredientList.forEach { daoHelper.ingredientDao.insertIngredient(it) }

    override suspend fun insertRecipeAndTagCrossRefs(crossRefs: List<RecipeAndTagCrossRef>) =
        crossRefs.forEach { daoHelper.recipeDao.insertRecipeAndTagCrossRef(it) }

    override suspend fun insertRecipeAndIngredientCrossRefs(crossRefs: List<RecipeAndIngredientCrossRef>) =
        crossRefs.forEach { daoHelper.recipeDao.insertRecipeAndIngredientCrossRef(it) }

    override suspend fun insertRecipeAndCategoryCrossRef(crossRef: RecipeAndCategoryCrossRef) =
        daoHelper.recipeDao.insertRecipeAndCategoryCrossRef(crossRef)
}
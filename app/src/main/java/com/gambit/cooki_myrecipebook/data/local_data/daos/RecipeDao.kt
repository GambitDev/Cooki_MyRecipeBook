package com.gambit.cooki_myrecipebook.data.local_data.daos

import androidx.room.*
import com.gambit.cooki_myrecipebook.data.local_data.entities.Recipe
import com.gambit.cooki_myrecipebook.data.local_data.entities.RecipeEntity
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndCategoryCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndIngredientCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndTagCrossRef
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipe(recipeEntity: RecipeEntity)

    @Update
    suspend fun updateRecipe(recipeEntity: RecipeEntity)

    @Delete
    suspend fun deleteRecipe(recipeEntity: RecipeEntity)

    @Transaction
    @Query("SELECT * FROM recipes")
    suspend fun getAllRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE id = :id")
    suspend fun getRecipeById(id: Int): Recipe

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipeAndTagCrossRef(crossRef: RecipeAndTagCrossRef)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipeAndIngredientCrossRef(crossRef: RecipeAndIngredientCrossRef)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipeAndCategoryCrossRef(crossRef: RecipeAndCategoryCrossRef)
}
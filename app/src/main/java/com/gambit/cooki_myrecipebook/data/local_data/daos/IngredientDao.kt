package com.gambit.cooki_myrecipebook.data.local_data.daos

import androidx.room.*
import com.gambit.cooki_myrecipebook.data.local_data.entities.Ingredient
import kotlinx.coroutines.flow.Flow

@Dao
interface IngredientDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIngredient(ingredient: Ingredient)

    @Delete
    suspend fun deleteIngredient(ingredient: Ingredient)

    @Query("SELECT * FROM ingredients")
    suspend fun getAllIngredients(): Flow<List<Ingredient>>

    @Query("SELECT * FROM ingredients WHERE id = :id")
    suspend fun getIngredientById(id: Int): Ingredient

    @Query("SELECT * FROM ingredients WHERE name LIKE '%' || :query || '%'")
    suspend fun searchForAutoCompleteCandidates(query: String): Flow<List<Ingredient>>
}
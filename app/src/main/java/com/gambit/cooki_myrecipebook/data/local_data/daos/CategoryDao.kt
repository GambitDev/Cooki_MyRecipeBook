package com.gambit.cooki_myrecipebook.data.local_data.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gambit.cooki_myrecipebook.data.local_data.entities.Category
import kotlinx.coroutines.flow.Flow

interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): Flow<List<Category>>

    @Query("SELECT * FROM categories WHERE id = :id")
    suspend fun getCategoryById(id: Int): Category

    @Query("SELECT * FROM categories WHERE name LIKE '%' || :query || '%'")
    suspend fun searchForAutoCompleteCandidates(query: String): Flow<List<Category>>
}
package com.gambit.cooki_myrecipebook.data.local_data.daos

import androidx.room.*
import com.gambit.cooki_myrecipebook.data.local_data.entities.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<Category>

    @Query("SELECT * FROM categories WHERE name = :name")
    suspend fun getCategoryByName(name: String): Category

    @Query("SELECT * FROM categories WHERE name LIKE '%' || :query || '%'")
    suspend fun searchForAutoCompleteCandidates(query: String): List<Category>
}
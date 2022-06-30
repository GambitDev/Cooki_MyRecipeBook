package com.gambit.cooki_myrecipebook.data.local_data.daos

import androidx.room.*
import com.gambit.cooki_myrecipebook.data.local_data.entities.Tag
import kotlinx.coroutines.flow.Flow

@Dao
interface TagDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTag(tag: Tag)

    @Delete
    suspend fun deleteTag(tag: Tag)

    @Query("SELECT * FROM tags")
    suspend fun getAllTags(): Flow<List<Tag>>

    @Query("SELECT * FROM tags WHERE id = :id")
    suspend fun getTagById(id: Int): Tag

    @Query("SELECT * FROM tags WHERE name LIKE '%' || :query || '%'")
    suspend fun searchForAutoCompleteCandidates(query: String): Flow<List<Tag>>
}
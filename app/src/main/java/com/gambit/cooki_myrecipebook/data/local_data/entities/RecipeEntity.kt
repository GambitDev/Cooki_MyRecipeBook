package com.gambit.cooki_myrecipebook.data.local_data.entities

import androidx.room.*
import com.gambit.cooki_myrecipebook.data.local_data.entities.enums.SkillLevel

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val instructions: List<String>,
    val dateCreated: Long,
    val imagesUriList: List<String>,
    val servings: Int,
    val cookingTime: Long,
    val skillLevel: SkillLevel
)
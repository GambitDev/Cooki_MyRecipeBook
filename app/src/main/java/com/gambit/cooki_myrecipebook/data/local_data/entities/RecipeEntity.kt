package com.gambit.cooki_myrecipebook.data.local_data.entities

import androidx.room.*
import com.gambit.cooki_myrecipebook.data.local_data.entities.enums.SkillLevel

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    var recipeId: Int = 0,
    var title: String,
    var description: String,
    var instructions: List<String>,
    var dateCreated: Long,
    var imagesUriList: List<String>,
    var servings: Int,
    var cookingTime: Long,
    var skillLevel: SkillLevel
) {
    companion object {
        fun emptyObject() =
            RecipeEntity(
                title = "",
                description = "",
                instructions = emptyList(),
                dateCreated = System.currentTimeMillis(),
                imagesUriList = emptyList(),
                servings = 0,
                cookingTime = 0,
                skillLevel = SkillLevel.NoSkill
            )
    }
}
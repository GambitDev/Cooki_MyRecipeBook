package com.gambit.cooki_myrecipebook.data.local_data.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndCategoryCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndIngredientCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndTagCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.enums.SkillLevel

data class Recipe(
    var recipeId: Int = 0,
    var title: String,
    var description: String,
    var instructions: List<String>,
    var dateCreated: Long,
    var imagesUriList: List<String>,
    var servings: Int,
    var cookingTime: Long,
    var skillLevel: SkillLevel,
    @Relation(
        parentColumn = "recipeId",
        entity = Ingredient::class,
        entityColumn = "name",
        associateBy = Junction(
            value = RecipeAndIngredientCrossRef::class,
            parentColumn = "recipeId",
            entityColumn = "name"
        )
    )
    var ingredients: List<Ingredient>,
    @Relation(
        parentColumn = "recipeId",
        entity = Tag::class,
        entityColumn = "name",
        associateBy = Junction(
            value = RecipeAndTagCrossRef::class,
            parentColumn = "recipeId",
            entityColumn = "name"
        )
    )
    var tags: List<Tag>,
    @Relation(
        parentColumn = "recipeId",
        entity = Category::class,
        entityColumn = "name",
        associateBy = Junction(
            value = RecipeAndCategoryCrossRef::class,
            parentColumn = "recipeId",
            entityColumn = "name"
        )
    )
    var category: Category
)

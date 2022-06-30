package com.gambit.cooki_myrecipebook.data.local_data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gambit.cooki_myrecipebook.data.local_data.daos.CategoryDao
import com.gambit.cooki_myrecipebook.data.local_data.daos.IngredientDao
import com.gambit.cooki_myrecipebook.data.local_data.daos.RecipeDao
import com.gambit.cooki_myrecipebook.data.local_data.daos.TagDao
import com.gambit.cooki_myrecipebook.data.local_data.entities.Category
import com.gambit.cooki_myrecipebook.data.local_data.entities.Ingredient
import com.gambit.cooki_myrecipebook.data.local_data.entities.RecipeEntity
import com.gambit.cooki_myrecipebook.data.local_data.entities.Tag
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndCategoryCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndIngredientCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.entities.cross_refs.RecipeAndTagCrossRef
import com.gambit.cooki_myrecipebook.data.local_data.type_converters.Converters

@Database(
    entities = [
        RecipeEntity::class,
        Category::class,
        Ingredient::class,
        Tag::class,
        RecipeAndTagCrossRef::class,
        RecipeAndCategoryCrossRef::class,
        RecipeAndIngredientCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
    abstract fun tagDao(): TagDao
    abstract fun ingredientsDao(): IngredientDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var Instance: RecipeDatabase? = null

        fun getDatabase(context: Context): RecipeDatabase {
            return Instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeDatabase::class.java,
                    "recipe_db"
                ).build()
                Instance = instance
                instance
            }
        }
    }
}
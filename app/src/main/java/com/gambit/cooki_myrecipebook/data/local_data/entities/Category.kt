package com.gambit.cooki_myrecipebook.data.local_data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey
    var name: String
)

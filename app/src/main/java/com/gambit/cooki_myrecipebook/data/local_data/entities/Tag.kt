package com.gambit.cooki_myrecipebook.data.local_data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tags")
data class Tag(
    @PrimaryKey
    val name: String
)
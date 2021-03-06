package com.gambit.cooki_myrecipebook.data.local_data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gambit.cooki_myrecipebook.data.local_data.entities.enums.MeasurementType

@Entity(tableName = "ingredients")
data class Ingredient(
    @PrimaryKey
    var name: String,
    var measurement: Measurement
)

data class Measurement(
    var amount: Float,
    var type: MeasurementType
)

package com.gambit.cooki_myrecipebook.data.local_data.type_converters

import androidx.room.TypeConverter
import com.gambit.cooki_myrecipebook.data.local_data.entities.Measurement
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun measurementToJson(measurement: Measurement): String =
        Gson().toJson(measurement)

    @TypeConverter
    fun jsonToMeasurement(json: String): Measurement =
        Gson().fromJson(json, Measurement::class.java)

    @TypeConverter
    fun stringListToJson(list: List<String>): String =
        Gson().toJson(list)

    @TypeConverter
    fun jsonToStringList(json: String): List<String> {
        val type = object: TypeToken<List<String>>() {}.type
        return Gson().fromJson(json, type)
    }
}
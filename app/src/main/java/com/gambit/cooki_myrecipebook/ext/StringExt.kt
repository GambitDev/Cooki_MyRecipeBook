package com.gambit.cooki_myrecipebook.ext

fun String.isOnlyNumericCharacters() =
    if (isEmpty()) true
    else try {
        toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
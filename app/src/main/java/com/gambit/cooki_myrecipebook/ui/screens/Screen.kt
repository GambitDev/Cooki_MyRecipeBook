package com.gambit.cooki_myrecipebook.ui.screens

sealed class Screen(val route: String) {
    object AddRecipeScreen: Screen("add_recipe")
}

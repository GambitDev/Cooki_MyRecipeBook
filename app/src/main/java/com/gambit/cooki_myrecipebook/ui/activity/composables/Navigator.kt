package com.gambit.cooki_myrecipebook.ui.activity.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gambit.cooki_myrecipebook.ui.screens.Screen
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.AddRecipeScreen
import com.gambit.cooki_myrecipebook.ui.theme.CookiMyRecipeBookTheme

@Composable
fun Navigator(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.AddRecipeScreen.route
    ) {
        composable(route = Screen.AddRecipeScreen.route) {
            AddRecipeScreen()
        }
    }
}
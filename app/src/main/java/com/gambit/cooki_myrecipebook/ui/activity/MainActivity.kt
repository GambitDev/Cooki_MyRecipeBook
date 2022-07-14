package com.gambit.cooki_myrecipebook.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gambit.cooki_myrecipebook.ui.activity.composables.App
import com.gambit.cooki_myrecipebook.ui.activity.composables.TopBar
import com.gambit.cooki_myrecipebook.ui.screens.Screen
import com.gambit.cooki_myrecipebook.ui.screens.add_recipe.AddRecipeScreen
import com.gambit.cooki_myrecipebook.ui.theme.CookiMyRecipeBookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CookiMyRecipeBookTheme {
                App()
            }
        }
    }
}
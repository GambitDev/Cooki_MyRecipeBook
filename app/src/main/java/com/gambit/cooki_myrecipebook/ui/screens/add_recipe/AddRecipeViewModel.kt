package com.gambit.cooki_myrecipebook.ui.screens.add_recipe

import androidx.lifecycle.ViewModel
import com.gambit.cooki_myrecipebook.data.repositories.Repository

class AddRecipeViewModel(
    private val repository: Repository,
    private val stateHolder: RecipeStateHolder = RecipeStateHolder()
): ViewModel() {

}

class RecipeStateHolder {

}
package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.steps

enum class AddRecipeStep {
    Details, Ingredients, Instructions, Metadata, Images;

    companion object {
        fun count() = values().size
        fun getStepAt(index: Int) = values()[index]
    }
}

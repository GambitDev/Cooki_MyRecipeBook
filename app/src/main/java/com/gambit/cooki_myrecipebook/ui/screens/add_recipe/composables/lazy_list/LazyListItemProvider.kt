package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables.lazy_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider

@ExperimentalFoundationApi
interface LazyListItemProvider : LazyLayoutItemProvider {
    /** The list of indexes of the sticky header items */
    val headerIndexes: List<Int>
    /** The scope used by the item content lambdas */
    val itemScope: LazyItemScopeImpl
}
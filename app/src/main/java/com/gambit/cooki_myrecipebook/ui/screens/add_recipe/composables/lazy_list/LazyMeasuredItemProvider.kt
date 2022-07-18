package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables.lazy_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.Constraints

/**
 * Abstracts away the subcomposition from the measuring logic.
 */
@OptIn(ExperimentalFoundationApi::class)
class LazyMeasuredItemProvider @ExperimentalFoundationApi constructor(
    constraints: Constraints,
    isVertical: Boolean,
    private val itemProvider: LazyListItemProvider,
    private val measureScope: LazyLayoutMeasureScope,
    private val measuredItemFactory: MeasuredItemFactory
) {
    // the constraints we will measure child with. the main axis is not restricted
    val childConstraints = Constraints(
        maxWidth = if (isVertical) constraints.maxWidth else Constraints.Infinity,
        maxHeight = if (!isVertical) constraints.maxHeight else Constraints.Infinity
    )

    /**
     * Used to subcompose items of lazy lists. Composed placeables will be measured with the
     * correct constraints and wrapped into [LazyMeasuredItem].
     */
    fun getAndMeasure(index: DataIndex): LazyMeasuredItem {
        val key = itemProvider.getKey(index.value)
        val placeables = measureScope.measure(index.value, childConstraints)
        return measuredItemFactory.createItem(index, key, placeables)
    }

    /**
     * Contains the mapping between the key and the index. It could contain not all the items of
     * the list as an optimization.
     **/
    val keyToIndexMap: Map<Any, Int> get() = itemProvider.keyToIndexMap
}

// This interface allows to avoid autoboxing on index param
fun interface MeasuredItemFactory {
    fun createItem(
        index: DataIndex,
        key: Any,
        placeables: Array<Placeable>
    ): LazyMeasuredItem
}

package com.gambit.cooki_myrecipebook.ui.screens.add_recipe.composables.lazy_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.layout.IntervalList
import androidx.compose.foundation.lazy.layout.MutableIntervalList
import androidx.compose.runtime.Composable

@OptIn(ExperimentalFoundationApi::class)
internal class LazyListScopeImpl : LazyListScope {

    private val _intervals = MutableIntervalList<LazyListIntervalContent>()
    val intervals: IntervalList<LazyListIntervalContent> = _intervals

    private var _headerIndexes: MutableList<Int>? = null
    val headerIndexes: List<Int> get() = _headerIndexes ?: emptyList()

    override fun items(
        count: Int,
        key: ((index: Int) -> Any)?,
        contentType: (index: Int) -> Any?,
        itemContent: @Composable LazyItemScope.(index: Int) -> Unit
    ) {
        _intervals.addInterval(
            count,
            LazyListIntervalContent(
                key = key,
                type = contentType,
                item = itemContent
            )
        )
    }

    override fun item(key: Any?, contentType: Any?, content: @Composable LazyItemScope.() -> Unit) {
        _intervals.addInterval(
            1,
            LazyListIntervalContent(
                key = if (key != null) { _: Int -> key } else null,
                type = { contentType },
                item = { content() }
            )
        )
    }

    @ExperimentalFoundationApi
    override fun stickyHeader(
        key: Any?,
        contentType: Any?,
        content: @Composable LazyItemScope.() -> Unit
    ) {
        val headersIndexes = _headerIndexes ?: mutableListOf<Int>().also {
            _headerIndexes = it
        }
        headersIndexes.add(_intervals.size)

        item(key, contentType, content)
    }
}

internal class LazyListIntervalContent(
    val key: ((index: Int) -> Any)?,
    val type: ((index: Int) -> Any?),
    val item: @Composable LazyItemScope.(index: Int) -> Unit
)
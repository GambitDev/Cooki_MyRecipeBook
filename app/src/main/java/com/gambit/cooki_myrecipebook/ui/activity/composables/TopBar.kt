package com.gambit.cooki_myrecipebook.ui.activity.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gambit.cooki_myrecipebook.R
import com.gambit.cooki_myrecipebook.ext.mirror
import com.gambit.cooki_myrecipebook.ui.theme.CookiMyRecipeBookTheme
import kotlinx.coroutines.launch

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    drawerClosed: Boolean,
    openDrawer: suspend () -> Unit,
    closeDrawer: suspend () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colorScheme.primary,
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        val scope = rememberCoroutineScope()
        IconButton(
            onClick = {
                scope.launch {
                    if (drawerClosed) openDrawer() else closeDrawer()
                }
            }
        ) {
            Icon(
                modifier = Modifier.mirror(),
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = stringResource(id = R.string.toggle_menu),
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(48.dp).padding(4.dp),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun LightTopBarPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        TopBar(
            drawerClosed = true,
            openDrawer = {},
            closeDrawer = {}
        )
    }
}

@Preview
@Composable
fun DarkTopBarPreview() {
    CookiMyRecipeBookTheme(
        darkTheme = true,
        dynamicColor = false
    ) {
        TopBar(
            drawerClosed = true,
            openDrawer = {},
            closeDrawer = {}
        )
    }
}
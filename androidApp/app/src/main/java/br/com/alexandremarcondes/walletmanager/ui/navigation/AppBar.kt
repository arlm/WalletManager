package br.com.alexandremarcondes.walletmanager.ui.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import br.com.alexandremarcondes.walletmanager.ui.theme.AndroidPhonePreviews
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    drawerState: DrawerState?,
    title: String,
    hasValidSeed: Boolean
) {
    val coroutineScope = rememberCoroutineScope()

    CenterAlignedTopAppBar(
        navigationIcon = {
            if (drawerState != null) {
                IconButton(onClick = {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                }) {
                    Icon(Icons.Filled.Menu, contentDescription = "")
                }
            }
        },
        title = { Text(text = title) },
        actions = {
            if (hasValidSeed) {
                Icon(
                    Icons.Default.CheckCircleOutline,
                    "Ready",
                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                )
            }
        }
    )
}

@AndroidPhonePreviews
@Composable
fun PreviewAppBar_NotReady() {
    ApplicationTheme {
        AppBar(drawerState = rememberDrawerState(initialValue = DrawerValue.Open), "Title", false)
    }
}

@AndroidPhonePreviews
@Composable
fun PreviewAppBar_Ready() {
    ApplicationTheme {
        AppBar(drawerState = rememberDrawerState(initialValue = DrawerValue.Open), "Title", true)
    }
}
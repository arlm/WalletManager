package br.com.alexandremarcondes.walletmanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.alexandremarcondes.walletmanager.MainApp
import br.com.alexandremarcondes.walletmanager.ui.components.KeyboardAware
import br.com.alexandremarcondes.walletmanager.ui.navigation.AppBar
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkDynamicColorsPreview
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkModesPreview

@Composable
fun BIP85Screen(drawerState: DrawerState) {
    val hasValidSeed by remember { mutableStateOf(MainApp.memory.bip39.isValid) }

    Scaffold(
        topBar = { AppBar(
            drawerState = drawerState,
            title = "Child Key",
            hasValidSeed = hasValidSeed
        ) }
    ) { paddingValues ->
        KeyboardAware () {
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = " Child Key Screen")
            }
        }
    }
}

@LightAndDarkModesPreview
@LightAndDarkDynamicColorsPreview
@Composable
fun PreviewBIP85Screen() {
    ApplicationTheme {
        BIP85Screen(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed))
    }
}
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
import br.com.alexandremarcondes.walletmanager.data.Memory
import br.com.alexandremarcondes.walletmanager.ui.components.KeyboardAware
import br.com.alexandremarcondes.walletmanager.ui.navigation.AppBar
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkDynamicColorsPreview
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkModesPreview

@Composable
fun BIP49Screen(drawerState: DrawerState) {
    val hasValidSeed by remember { mutableStateOf(MainApp.memory.bip39.isValid) }

    Scaffold(
        topBar = { AppBar(
            drawerState = drawerState,
            title = "P2WPKH-nested-in-P2SH Accounts",
            hasValidSeed = hasValidSeed
        ) }
    ) { paddingValues ->
        KeyboardAware () {
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "P2WPKH-nested-in-P2SH Accounts Screen")
            }
        }
    }
}

@LightAndDarkModesPreview
@LightAndDarkDynamicColorsPreview
@Composable
fun PreviewBIP49Screen() {
    ApplicationTheme {
        BIP49Screen(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed))
    }
}
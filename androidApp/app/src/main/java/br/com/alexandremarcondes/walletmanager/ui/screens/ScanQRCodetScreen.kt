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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.alexandremarcondes.walletmanager.MainApp
import br.com.alexandremarcondes.walletmanager.ui.navigation.AppBar
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkDynamicColorsPreview
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkModesPreview

@Composable
fun ScanQRCodeScreen(drawerState: DrawerState) {
    var hasValidSeed by remember { mutableStateOf(MainApp.memory.bip39.isValid) }

    Scaffold(
        topBar = { AppBar(
            drawerState = drawerState,
            title = "Scan QR-Code",
            hasValidSeed = hasValidSeed
        ) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Scan QR-Code Screen")
        }
    }
}

@LightAndDarkModesPreview
@LightAndDarkDynamicColorsPreview
@Composable
fun PreviewScanQRCodeScreen() {
    ApplicationTheme {
        ScanQRCodeScreen(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed))
    }
}
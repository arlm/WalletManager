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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.alexandremarcondes.walletmanager.ui.navigation.AppBar
import br.com.alexandremarcondes.walletmanager.ui.theme.AndroidPhonePreviews
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme

@Composable
fun ScanQRCodeScreen(drawerState: DrawerState) {
    Scaffold(
        topBar = { AppBar(
            drawerState = drawerState,
            title = "Scan QR-Code"
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

@AndroidPhonePreviews
@Composable
fun PreviewScanQRCodeScreen() {
    ApplicationTheme {
        ScanQRCodeScreen(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed))
    }
}
package br.com.alexandremarcondes.walletmanager.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import br.com.alexandremarcondes.walletmanager.MainApp
import br.com.alexandremarcondes.walletmanager.bitcoin.Bip32
import br.com.alexandremarcondes.walletmanager.ui.components.KeyboardAware
import br.com.alexandremarcondes.walletmanager.ui.components.qrcode.DotShape
import br.com.alexandremarcondes.walletmanager.ui.components.qrcode.QrCodeColors
import br.com.alexandremarcondes.walletmanager.ui.components.qrcode.QrCodeView
import br.com.alexandremarcondes.walletmanager.ui.navigation.AppBar
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkDynamicColorsPreview
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkModesPreview

@Composable
fun BIP32Screen(drawerState: DrawerState) {
    val hasValidSeed by remember { mutableStateOf(MainApp.memory.bip39.isValid) }

    Scaffold(
        topBar = {
            AppBar(
                drawerState = drawerState,
                title = "HD Wallet",
                hasValidSeed = hasValidSeed
            )
        }
    ) { paddingValues ->
        var showQrCode by remember { mutableStateOf(false) }
        var qrCodeData by remember { mutableStateOf("") }

        val rootKey = if (hasValidSeed) Bip32(MainApp.memory.bip39) else null

        KeyboardAware {
            if (showQrCode) {
                Dialog(onDismissRequest = { showQrCode = false }) {
                    Card(
                        modifier = Modifier
                            .size(400.dp)
                            .padding(16.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color.White),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            QrCodeView(
                                qrCodeData,
                                modifier = Modifier.size(280.dp),
                                colors = QrCodeColors(
                                    background = Color.White,
                                    foreground = Color.Black
                                ),
                                dotShape = DotShape.Circle
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (rootKey != null) {
                    Text("mainnet", style = MaterialTheme.typography.titleMedium)
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = "Private Root Key: ")
                            IconButton(
                                onClick = {
                                    qrCodeData = rootKey.mainnetPrivateKey
                                    showQrCode = true
                                }
                            ) {
                                Icon(
                                    Icons.Default.QrCode,
                                    contentDescription = "Reset",
                                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                                )
                            }
                        }
                        SelectionContainer {
                            Text(text = rootKey.mainnetPrivateKey)
                        }
                    }
                    Spacer(Modifier.height(4.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = "Public Root Key: ")
                            IconButton(
                                onClick = {
                                    qrCodeData = rootKey.mainnetPublicKey
                                    showQrCode = true
                                }
                            ) {
                                Icon(
                                    Icons.Default.QrCode,
                                    contentDescription = "Reset",
                                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                                )
                            }
                        }
                        SelectionContainer {
                            Text(text = rootKey.mainnetPublicKey)
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                    Text("testnet", style = MaterialTheme.typography.titleMedium)
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = "Private Root Key: ")
                            IconButton(
                                onClick = {
                                    qrCodeData = rootKey.testnetPrivateKey
                                    showQrCode = true
                                }
                            ) {
                                Icon(
                                    Icons.Default.QrCode,
                                    contentDescription = "Reset",
                                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                                )
                            }
                        }
                        SelectionContainer {
                            Text(text = rootKey.testnetPrivateKey)
                        }
                    }
                    Spacer(Modifier.height(4.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = "Public Root Key: ")
                            IconButton(
                                onClick = {
                                    qrCodeData = rootKey.testnetPublicKey
                                    showQrCode = true
                                }
                            ) {
                                Icon(
                                    Icons.Default.QrCode,
                                    contentDescription = "Reset",
                                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                                )
                            }
                        }
                        SelectionContainer {
                            Text(text = rootKey.testnetPublicKey)
                        }
                    }
                } else {
                    Text(text = "Enter the seed words or scan a QR-Code")
                }
            }
        }
    }
}

@LightAndDarkModesPreview
@LightAndDarkDynamicColorsPreview
@Composable
fun PreviewBIP32Screen() {
    ApplicationTheme {
        BIP32Screen(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed))
    }
}
package br.com.alexandremarcondes.walletmanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.alexandremarcondes.walletmanager.bitcoin.Bip32
import br.com.alexandremarcondes.walletmanager.bitcoin.Bip39
import br.com.alexandremarcondes.walletmanager.data.Bip39Data
import br.com.alexandremarcondes.walletmanager.ui.components.KeyPairItem
import br.com.alexandremarcondes.walletmanager.ui.components.KeyboardAware
import br.com.alexandremarcondes.walletmanager.ui.components.qrcode.QrCodeDialog
import br.com.alexandremarcondes.walletmanager.ui.navigation.AppBar
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkDynamicColorsPreview
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkModesPreview
import br.com.alexandremarcondes.walletmanager.wordlists.englishWordlist

@Composable
fun BIP32Screen(
    drawerState: DrawerState,
    data: Bip39Data,
    expanded: Boolean = false) {
    val hasValidSeed by remember { mutableStateOf(data.isValid) }
    var isMainnet by remember { mutableStateOf(true) }

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

        val rootKey = if (hasValidSeed) Bip32(data) else null

        KeyboardAware {
            QrCodeDialog (
                data = qrCodeData,
                visible = showQrCode
            ) {
                showQrCode = false
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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(if (isMainnet) "mainnet" else "testnet",
                            modifier = Modifier.padding(top = 12.dp),
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Switch(isMainnet,
                            onCheckedChange = { value -> isMainnet = value }
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                    KeyPairItem(
                        privateKey = if (isMainnet) rootKey.mainnetPrivateKey else rootKey.testnetPrivateKey,
                        privateKeyLabel = "Private Key:",
                        publicKey = if (isMainnet) rootKey.mainnetPublicKey else rootKey.testnetPublicKey,
                        publicKeyLabel = "Public Key:",
                        title = "HD Wallet Root Key",
                        expanded = expanded
                    ) { data ->
                        qrCodeData = data
                        showQrCode = true
                    }
                    Spacer(Modifier.height(16.dp))
                    Text("Accounts", style = MaterialTheme.typography.titleMedium)

                } else {
                    Text(text = "Enter the seed words or scan a QR-Code")
                }
            }
        }
    }
}

@LightAndDarkModesPreview
@Composable
fun PreviewBIP32Screen_Empty() {
    ApplicationTheme {
        BIP32Screen(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed), Bip39Data())
    }
}

@LightAndDarkModesPreview
@Composable
fun PreviewBIP32Screen_Collapsed() {
    ApplicationTheme {
        val data = Bip39(arrayOf(
                "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "abandon",
                "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "abandon",
                "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "art",
            ),
            englishWordlist)
        BIP32Screen(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed), Bip39Data(data), expanded = false)
    }
}

@LightAndDarkModesPreview
@LightAndDarkDynamicColorsPreview
@Composable
fun PreviewBIP32Screen_Expanded() {
    ApplicationTheme {
        val data = Bip39(arrayOf(
            "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "abandon",
            "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "abandon",
            "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "abandon", "art",
        ),
            englishWordlist)
        BIP32Screen(drawerState = rememberDrawerState(initialValue = DrawerValue.Closed), Bip39Data(data), expanded = true)
    }
}
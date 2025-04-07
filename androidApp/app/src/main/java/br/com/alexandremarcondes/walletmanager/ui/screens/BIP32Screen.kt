package br.com.alexandremarcondes.walletmanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
        var account by remember { mutableStateOf("") }
        var accountsToGenerate by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var isMainnet by remember { mutableStateOf(true) }
        var isExternal by remember { mutableStateOf(true) }

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
                    Text("Accounts", style = MaterialTheme.typography.titleLarge)
                    Card (
                        shape = RoundedCornerShape(8.dp),
                        elevation = CardDefaults.cardElevation(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Column (
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextField(
                                value = account,
                                onValueChange = { },
                                enabled = true,
                                readOnly = false,
                                label = { Text("Wallet / Account") },
                                placeholder = { Text("Enter the wallet or account number") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(Modifier.height(16.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Spacer(modifier = Modifier.width(16.dp))
                                Switch(isExternal,
                                    onCheckedChange = { value -> isExternal = value },
                                    modifier = Modifier.size(width = 75.dp, height = 24.dp)
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(if (isExternal) "External" else "Internal",
                                    modifier = Modifier.padding(top = 4.dp),
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                            Spacer(Modifier.height(8.dp))
                            TextField(
                                value = address,
                                onValueChange = { },
                                enabled = true,
                                readOnly = false,
                                label = { Text("Address") },
                                placeholder = { Text("Enter the address number") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(Modifier.height(24.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Spacer(Modifier.width(16.dp))
                                Text("Path: ", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium))
                                Spacer(Modifier.width(8.dp))
                                SelectionContainer {
                                    Text("m/${if (account.isEmpty()) "0" else account}/${if (isExternal) "0" else "1"}/${if (address.isEmpty()) "0" else address}")
                                }
                            }
                            Spacer(Modifier.height(16.dp))
                        }
                    }
                    Text("Batch Generation", style = MaterialTheme.typography.titleLarge)
                    Card (
                        shape = RoundedCornerShape(8.dp),
                        elevation = CardDefaults.cardElevation(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Column (
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextField(
                                value = accountsToGenerate,
                                onValueChange = { },
                                enabled = true,
                                readOnly = false,
                                label = { Text("Accounts to Generate") },
                                placeholder = { Text("Enter the number of accounts to generate") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(Modifier.height(16.dp))
                            Row (
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Button(
                                    modifier = Modifier.padding(end = 16.dp),
                                    onClick = {
                                    },
                                ) {
                                    Text("Generate")
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Icon(
                                        Icons.Default.Construction,
                                        contentDescription = "Generate",
                                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                                    )
                                }
                            }
                            Spacer(Modifier.height(16.dp))
                            Text("Account List: ",
                                modifier = Modifier.padding(start = 16.dp),
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                            )
                            Spacer(Modifier.height(8.dp))
                            SelectionContainer {
                                Text("",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .heightIn(min = 75.dp, max = 240.dp)
                                        .padding(horizontal = 16.dp)
                                )
                            }}
                    }
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
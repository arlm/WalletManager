package br.com.alexandremarcondes.walletmanager.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.alexandremarcondes.walletmanager.ui.components.qrcode.QrCodeDialog
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkPhonePreview

@Composable
fun KeyPairItem(
    privateKey: String,
    publicKey: String,
    title: String,
    privateKeyLabel: String,
    publicKeyLabel: String,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    onShowQRCode: (data: String) -> Unit,
) {
    ExpandableCard(
        title = title,
        modifier = modifier,
        expanded = expanded
    ) {
        Column {
            KeyItemRow(
                key = privateKey,
                label = privateKeyLabel,
            ) { data -> onShowQRCode(data) }
            Spacer(modifier = Modifier.height(8.dp))
            KeyItemRow(
                key = publicKey,
                label = publicKeyLabel,
            ) { data -> onShowQRCode(data) }
        }
    }
}

@LightAndDarkPhonePreview
@Composable
fun PreviewKeyPairItem_Collapsed() {
    ApplicationTheme {
        var showQrCode by remember { mutableStateOf(false) }
        var qrCodeData by remember { mutableStateOf("") }

        QrCodeDialog(
            data = qrCodeData,
            visible = showQrCode
        ) {
            showQrCode = false
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            KeyPairItem (
                privateKey = "xprv9s21ZrQH143K3QTDL4LXw2F7HEK3wJUD2nW2nRk4stbPy6cq3jPPqjiChkVvvNKmPGJxWUtg6LnF5kejMRNNU3TGtRBeJgk33yuGBxrMPHi",
                privateKeyLabel = "Private key:",
                publicKey = "xprv9s21ZrQH143K3QTDL4LXw2F7HEK3wJUD2nW2nRk4stbPy6cq3jPPqjiChkVvvNKmPGJxWUtg6LnF5kejMRNNU3TGtRBeJgk33yuGBxrMPHi",
                publicKeyLabel = "Public key:",
                title = "Root BIP-32 keys"
            ) { data ->
                qrCodeData = data
                showQrCode = true
            }
        }
    }
}

@LightAndDarkPhonePreview
@Composable
fun PreviewKeyPairItem_Expanded() {
    ApplicationTheme {
        var showQrCode by remember { mutableStateOf(false) }
        var qrCodeData by remember { mutableStateOf("") }

        QrCodeDialog(
            data = qrCodeData,
            visible = showQrCode
        ) {
            showQrCode = false
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            KeyPairItem (
                privateKey = "xprv9s21ZrQH143K3QTDL4LXw2F7HEK3wJUD2nW2nRk4stbPy6cq3jPPqjiChkVvvNKmPGJxWUtg6LnF5kejMRNNU3TGtRBeJgk33yuGBxrMPHi",
                privateKeyLabel = "Private key:",
                publicKey = "xprv9s21ZrQH143K3QTDL4LXw2F7HEK3wJUD2nW2nRk4stbPy6cq3jPPqjiChkVvvNKmPGJxWUtg6LnF5kejMRNNU3TGtRBeJgk33yuGBxrMPHi",
                publicKeyLabel = "Public key:",
                title = "Root BIP-32 key",
                expanded = true
            ) { data ->
                qrCodeData = data
                showQrCode = true
            }
        }
    }
}
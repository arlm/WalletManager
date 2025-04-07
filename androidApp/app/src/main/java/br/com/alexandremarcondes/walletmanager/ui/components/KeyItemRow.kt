package br.com.alexandremarcondes.walletmanager.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
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
fun KeyItemRow(
    key: String,
    label: String,
    modifier: Modifier = Modifier,
    onShowQRCode: (data: String) -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = label)
            Spacer(modifier = Modifier.height(16.dp))
            IconButton(
                onClick = { onShowQRCode(key) }
            ) {
                Icon(
                    Icons.Default.QrCode,
                    contentDescription = "Show QR-Code",
                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        Spacer(modifier = Modifier.width(16.dp))
        SelectionContainer {
            Text(text = key)
        }
    }
}

@LightAndDarkPhonePreview
@Composable
fun PreviewKeyItemRow() {
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
            KeyItemRow(
                key = "xprv9s21ZrQH143K3QTDL4LXw2F7HEK3wJUD2nW2nRk4stbPy6cq3jPPqjiChkVvvNKmPGJxWUtg6LnF5kejMRNNU3TGtRBeJgk33yuGBxrMPHi",
                label = "Private Root BIP-32 key"
            ) { data ->
                qrCodeData = data
                showQrCode = true
            }
        }
    }
}

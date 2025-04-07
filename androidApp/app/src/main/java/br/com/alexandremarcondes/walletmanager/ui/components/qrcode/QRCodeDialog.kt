package br.com.alexandremarcondes.walletmanager.ui.components.qrcode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkPhonePreview

@Composable
fun QrCodeDialog(
    data: String,
    modifier: Modifier = Modifier,
    visible: Boolean = false,
    dialogSize: Dp = 400.dp,
    cornerSize: Dp = 16.dp,
    qrCodeSize: Dp = 280.dp,
    dotShape: DotShape = DotShape.Circle,
    background: Color = Color.White,
    foreground: Color = Color.Black,
    onDismiss: () -> Unit,
) {
    if (visible) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Card(
                modifier = modifier
                    .size(dialogSize)
                    .padding(cornerSize),
                shape = RoundedCornerShape(cornerSize)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = background),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    QrCodeView(
                        data,
                        modifier = Modifier.size(qrCodeSize),
                        colors = QrCodeColors(
                            background = background,
                            foreground = foreground
                        ),
                        dotShape = dotShape
                    )
                }
            }
        }
    }
}

@LightAndDarkPhonePreview
@Composable
fun PreviewDialog_Visible() {
    ApplicationTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            QrCodeDialog(
                data = "xprv9s21ZrQH143K3QTDL4LXw2F7HEK3wJUD2nW2nRk4stbPy6cq3jPPqjiChkVvvNKmPGJxWUtg6LnF5kejMRNNU3TGtRBeJgk33yuGBxrMPHi",
                visible = true
            ) { }
        }
    }
}

@LightAndDarkPhonePreview
@Composable
fun PreviewDialog_NonVisible() {
    ApplicationTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            QrCodeDialog(
                data = "xprv9s21ZrQH143K3QTDL4LXw2F7HEK3wJUD2nW2nRk4stbPy6cq3jPPqjiChkVvvNKmPGJxWUtg6LnF5kejMRNNU3TGtRBeJgk33yuGBxrMPHi",
                visible = false
            ) { }
        }
    }
}

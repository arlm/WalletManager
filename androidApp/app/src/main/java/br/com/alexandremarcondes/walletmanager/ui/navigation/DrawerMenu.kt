package br.com.alexandremarcondes.walletmanager.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AccountTree
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerMenu(val icon: ImageVector, override val title: String, val route: String) : DrawerMenuItem
data class DrawerMenuSeparator(override val title: String) : DrawerMenuItem
interface  DrawerMenuItem {
    val title: String
}

val menus = arrayOf(
    DrawerMenuSeparator("Input"),
    DrawerMenu(Icons.Default.QrCodeScanner, "Scan QR-Code", MainRoute.ScanQRCode.name),
    DrawerMenu(Icons.Default.Password, "Enter Mnemonic", MainRoute.MnemonicInput.name),
    DrawerMenuSeparator("Regular Wallet"),
    DrawerMenu(Icons.Default.QrCode, "SeedQR Creation", MainRoute.SeedQRCreation.name),
    DrawerMenu(Icons.Default.Key, "Child Key", MainRoute.BIP85.name),
    DrawerMenu(Icons.Default.AccountTree, "HD Wallet", MainRoute.BIP32.name),
    DrawerMenu(Icons.Default.AccountBalanceWallet, "Accounts", MainRoute.BIP44.name),
    DrawerMenuSeparator("Segregated Witness"),
    DrawerMenu(Icons.Default.Key, "SegWit Keys", MainRoute.BIP141.name),
    DrawerMenu(Icons.Default.AccountBalanceWallet, "P2WPKH Accounts", MainRoute.BIP84.name),
    DrawerMenu(Icons.Default.AccountBalanceWallet, "P2WPKH-nested-in-P2SH Accounts", MainRoute.BIP49.name)
)

package br.com.alexandremarcondes.walletmanager.ui.navigation

import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.alexandremarcondes.walletmanager.ui.screens.BIP141Screen
import br.com.alexandremarcondes.walletmanager.ui.screens.BIP32Screen
import br.com.alexandremarcondes.walletmanager.ui.screens.BIP44Screen
import br.com.alexandremarcondes.walletmanager.ui.screens.BIP49Screen
import br.com.alexandremarcondes.walletmanager.ui.screens.BIP84Screen
import br.com.alexandremarcondes.walletmanager.ui.screens.BIP85Screen
import br.com.alexandremarcondes.walletmanager.ui.theme.AndroidPhonePreviews
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import br.com.alexandremarcondes.walletmanager.ui.screens.ScanQRCodeScreen
import br.com.alexandremarcondes.walletmanager.ui.screens.SeedQRCreationScreen
import br.com.alexandremarcondes.walletmanager.ui.screens.MnemonicInputScreen

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppNavigationDrawer(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
) {
    DismissibleNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        drawerContent = {
            DismissibleDrawerSheet {
                DrawerContent(menus) { route ->
                    coroutineScope.launch {
                        drawerState.close()
                    }

                    navController.navigate(route)
                }
            }
        },
        gesturesEnabled = true
    ) {
        NavHost(navController = navController, startDestination = MainRoute.MnemonicInput.name) {
            composable(MainRoute.MnemonicInput.name) {
                MnemonicInputScreen(drawerState)
            }
            composable(MainRoute.ScanQRCode.name) {
                ScanQRCodeScreen(drawerState)
            }
            composable(MainRoute.SeedQRCreation.name) {
                SeedQRCreationScreen(drawerState)
            }
            composable(MainRoute.BIP32.name) {
                BIP32Screen(drawerState)
            }
            composable(MainRoute.BIP44.name) {
                BIP44Screen(drawerState)
            }
            composable(MainRoute.BIP49.name) {
                BIP49Screen(drawerState)
            }
            composable(MainRoute.BIP84.name) {
                BIP84Screen(drawerState)
            }
            composable(MainRoute.BIP85.name) {
                BIP85Screen(drawerState)
            }
            composable(MainRoute.BIP141.name) {
                BIP141Screen(drawerState)
            }
        }
    }
}

@AndroidPhonePreviews
@Composable
fun PreviewMessageCard_Open() {
    ApplicationTheme {
        AppNavigationDrawer(drawerState =rememberDrawerState(initialValue = DrawerValue.Open))
    }
}

@AndroidPhonePreviews
@Composable
fun PreviewMessageCard_Closed() {

    ApplicationTheme {
        ApplicationTheme {
            AppNavigationDrawer(drawerState =rememberDrawerState(initialValue = DrawerValue.Closed))
        }
    }
}
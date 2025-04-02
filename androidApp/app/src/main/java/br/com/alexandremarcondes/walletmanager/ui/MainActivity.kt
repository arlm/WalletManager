package br.com.alexandremarcondes.walletmanager.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import br.com.alexandremarcondes.walletmanager.ui.navigation.AppNavigationDrawer
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        enableEdgeToEdge()

        setContent {
            ApplicationTheme {
                AppNavigationDrawer()
            }
        }
    }
}
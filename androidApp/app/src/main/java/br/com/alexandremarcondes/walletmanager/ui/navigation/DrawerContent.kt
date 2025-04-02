package br.com.alexandremarcondes.walletmanager.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.alexandremarcondes.walletmanager.ui.theme.AndroidPhonePreviews
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme

@Composable
fun DrawerContent(
    menus: Array<DrawerMenuItem>,
    onMenuClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Spacer(modifier = Modifier.height(12.dp))
        menus.forEach {
            if (it is DrawerMenuSeparator) {
                Text(it.title, modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
            }

            if (it is DrawerMenu) {
                NavigationDrawerItem(
                    label = { Text(text = it.title, modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.labelLarge) },
                    icon = { Icon(imageVector = it.icon, contentDescription = null) },
                    selected = false,
                    onClick = {
                        onMenuClick(it.route)
                    }
                )
            }
        }
    }
}

@AndroidPhonePreviews
@Composable
fun PreviewDrawerContent() {
    ApplicationTheme {
        ApplicationTheme {
                DrawerContent(menus) {
            }
        }
    }
}

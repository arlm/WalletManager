package br.com.alexandremarcondes.walletmanager.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkDynamicColorsPreview
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkModesPreview

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WordList(
    modifier: Modifier = Modifier,
    wordlist: Array<String> = emptyArray(),
    enabled: Boolean = true,
    onRemove: (newWordlist: Array<String>) -> Unit
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = spacedBy(8.dp),
        verticalArrangement = Arrangement.Top,
        maxItemsInEachRow = 3
    ) {
        wordlist.forEachIndexed { index, item ->
            InputChip(
                selected = false,
                label = { Text(item) },
                onClick = { },
                enabled = enabled,
                trailingIcon = {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Localized description",
                        modifier = Modifier
                            .size(InputChipDefaults.AvatarSize)
                            .clickable {
                                val arrayList = wordlist.toCollection(ArrayList())
                                arrayList.removeAt(index)
                                onRemove(arrayList.toTypedArray())
                            }
                    )
                }
            )
        }
    }
}

@LightAndDarkModesPreview
@LightAndDarkDynamicColorsPreview
@Composable
fun PreviewWordList() {
    ApplicationTheme {
        var wordlist by remember { mutableStateOf(arrayOf("abandon", "test", "abandon", "test")) }
        Column {
            WordList( wordlist = wordlist) { newWordlist -> wordlist = newWordlist }

            Text(if (wordlist.isEmpty()) "Empty!" else wordlist.joinToString(separator = " "), modifier = Modifier.clickable {
                wordlist = arrayOf("abandon", "test")
            })
        }
    }
}

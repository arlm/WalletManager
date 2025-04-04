package br.com.alexandremarcondes.walletmanager.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkDynamicColorsPreview
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkModesPreview
import br.com.alexandremarcondes.walletmanager.wordlists.englishWordlist

@Composable
fun SuggestionView(modifier: Modifier = Modifier,
                   suggestions: Array<String> = emptyArray(),
                   wordlist: Array<String> = emptyArray(),
                   visible: Boolean = false,
                   onHide: () -> Unit,
                   onClick: (suggestion: String, newWordlist: Array<String>) -> Unit
) {
    if (visible) {
        Column(
            modifier = modifier
                .shadow(8.dp, RoundedCornerShape(8.dp))
                .background(
                    MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(8.dp)
                )
                .animateContentSize()
        ) {
            if (suggestions.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    items(
                        items = suggestions,
                        // Using the suggestion string as the key
                        key = { suggestion -> suggestion }
                    ) { suggestion ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onClick(suggestion, wordlist.plus(arrayOf(suggestion)))

                                    // Hide suggestions after selection
                                    onHide()
                                }
                                .padding(12.dp)
                        ) {
                            Text(
                                text = suggestion,
                                style = TextStyle(fontSize = 18.sp),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            } else {
                Text(
                    text = "No suggestions available",
                    style = TextStyle(color = Color.Gray, fontSize = 16.sp),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@LightAndDarkModesPreview
@LightAndDarkDynamicColorsPreview
@Composable
fun PreviewSuggestionView() {
    ApplicationTheme {
        var text by remember { mutableStateOf("") }
        var visibility by remember { mutableStateOf(true) }

        Column {
            SuggestionView(
                suggestions = englishWordlist.filter { it.startsWith("aba") }.toTypedArray(),
                visible = visibility,
                onHide = { visibility = false }
            ) { suggestion, _ ->
                text = suggestion
            }

            Text(text, modifier = Modifier.clickable {
                visibility = true
                text = ""
            })

            Button(onClick = {
                visibility = !visibility
            }) {
                Text(if (visibility) "Hide" else "Show")
                Icon(
                    if (visibility) Icons.Default.RemoveCircleOutline else Icons.Default.AddCircleOutline,
                    contentDescription = if (visibility) "Hide" else "Show",
                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                )
            }
        }
    }
}
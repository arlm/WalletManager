package br.com.alexandremarcondes.walletmanager.ui.screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.alexandremarcondes.walletmanager.bitcoin.bip39.Bip39
import br.com.alexandremarcondes.walletmanager.data.Bip39Data
import br.com.alexandremarcondes.walletmanager.data.Memory
import br.com.alexandremarcondes.walletmanager.ui.components.SuggestionView
import br.com.alexandremarcondes.walletmanager.ui.components.WordList
import br.com.alexandremarcondes.walletmanager.ui.navigation.AppBar
import br.com.alexandremarcondes.walletmanager.ui.theme.ApplicationTheme
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkDynamicColorsPreview
import br.com.alexandremarcondes.walletmanager.ui.theme.LightAndDarkModesPreview
import br.com.alexandremarcondes.walletmanager.wordlists.englishWordlist
import br.com.alexandremarcondes.walletmanager.wordlists.portugueseWordlist
import br.com.alexandremarcondes.walletmanager.wordlists.spanishWordlist

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MnemonicInputScreen(modifier: Modifier = Modifier,
                        drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
) {
    Scaffold(
        modifier = modifier,
        topBar = { AppBar(
            drawerState = drawerState,
            title = "Mnemonic Input"
        ) }
    ) { paddingValues ->
        val keyboardController = LocalSoftwareKeyboardController.current

        var bip39Dictionary by remember { mutableStateOf(englishWordlist) }
        var wordlist by remember { mutableStateOf(Memory.bip39.wordlist) }
        var value by remember { mutableStateOf(createEmptyValue()) }
        var errorMessage by remember { mutableStateOf("") }
        var informationMessage by remember { mutableStateOf("") }
        var filteredSuggestions by remember { mutableStateOf(bip39Dictionary.filter { !wordlist.contains(it) }.toTypedArray()) }
        var showSuggestions by remember { mutableStateOf(false) }
        var expanded by remember { mutableStateOf(false) }
        var selectedText by remember { mutableStateOf(if (wordlist.isEmpty()) "English" else Bip39.detectLanguage(wordlist)) }

        val focusRequester = remember { FocusRequester() }
        val isError by remember { derivedStateOf { errorMessage.isNotEmpty() } }
        val hasInput by remember { derivedStateOf { value.text.isNotEmpty() } }
        val hasWord by remember { derivedStateOf { wordlist.isNotEmpty() } }
        val isValidInput by remember { derivedStateOf { hasInput && filteredSuggestions.isNotEmpty() } }
        val isWordlistSizeValid by remember { derivedStateOf { wordlist.size in 12..24 } }
        val isWordlistValid by remember { derivedStateOf { wordlist.size % 3 == 0 } }

        LaunchedEffect(isWordlistSizeValid, isWordlistValid, hasWord) {
            informationMessage =  if (hasWord && isWordlistSizeValid) {
                if (isWordlistValid) {
                    if (Bip39.validate(wordlist, bip39Dictionary)) {
                        ""
                    } else {
                        "The words entered form an invalid passphrase"
                    }
                } else {
                    "The word list must be 12, 15, 18, 21 or 24 words long"
                }
            } else {
                ""
            }
        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .scrollable(rememberScrollState(), orientation = Orientation.Vertical, enabled = true),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(25.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = selectedText,
                    label = { Text("Language") },
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(text = "English") },
                        onClick = {
                            selectedText = "English"
                            bip39Dictionary = englishWordlist
                            expanded = false
                            wordlist = emptyArray()
                            filteredSuggestions = filterSuggestions(bip39Dictionary, value.text, wordlist)
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Português") },
                        onClick = {
                            selectedText = "Português"
                            bip39Dictionary = portugueseWordlist
                            expanded = false
                            wordlist = emptyArray()
                            filteredSuggestions = filterSuggestions(bip39Dictionary, value.text, wordlist)                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Español") },
                        onClick = {
                            selectedText = "Español"
                            bip39Dictionary = spanishWordlist
                            expanded = false
                            wordlist = emptyArray()
                            filteredSuggestions = filterSuggestions(bip39Dictionary, value.text, wordlist)                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = value,
                label = { Text("Word List") },
                placeholder = { Text("Enter your mnemonic words here") },
                singleLine = true,
                isError = isError,
                supportingText = {
                    if (isError) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                trailingIcon = {
                    if (isError)
                        Icon(Icons.Filled.Error,"error", tint = MaterialTheme.colorScheme.error)
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrectEnabled = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    showKeyboardOnFocus = true
                ),
                keyboardActions = KeyboardActions( onNext = { 
                    keyboardController?.hide()

                    if (hasInput && filteredSuggestions.size == 1) {
                        wordlist = updateWordlist(wordlist, filteredSuggestions.first())
                        value = createEmptyValue()

                        showSuggestions = false
                    } else {
                        errorMessage = "Invalid word"
                    }
                }),
                onValueChange = { newValue ->
                    if (newValue.text.isEmpty()) {
                        errorMessage = ""
                    } else {
                        filteredSuggestions = filterSuggestions(bip39Dictionary, newValue.text, wordlist)
                    }

                    if (newValue.text != value.text) {
                        value = if (newValue.text.endsWith(" ") && filteredSuggestions.size > 1) {
                            TextFieldValue(
                                text = newValue.text.trim(),
                                selection = TextRange(newValue.text.length - 1)
                            )
                        } else {
                            newValue
                        }
                        errorMessage = if (isValidInput || newValue.text == "") {  ""  } else { "Invalid word" }
                    }

                    showSuggestions = value.text.isNotEmpty()
                },
                modifier = Modifier
                    .onKeyEvent { event ->
                        return@onKeyEvent when (event.key.keyCode) {
                            Key.Enter.keyCode, Key.Spacebar.keyCode -> {
                                if (hasInput && filteredSuggestions.size == 1) {
                                    filteredSuggestions =
                                        filterSuggestions(bip39Dictionary, value.text, wordlist)
                                    wordlist = updateWordlist(wordlist, filteredSuggestions.first())
                                    value = createEmptyValue()

                                    showSuggestions = false
                                } else {
                                    errorMessage = "Invalid word"
                                }

                                true
                            }

                            else -> {
                                false
                            }
                        }
                    }
                    .focusRequester(focusRequester)
            )

            // Automatically request focus when the UI is composed
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }

            Spacer(modifier = Modifier.height(8.dp))

            SuggestionView(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .fillMaxHeight(0.33f),
                visible = showSuggestions,
                wordlist = wordlist,
                suggestions = filteredSuggestions,
                onHide = { showSuggestions = false }
            ) { word, newWordlist ->
                wordlist = newWordlist
                filteredSuggestions = filteredSuggestions.filter { it != word }.toTypedArray()
                value = createEmptyValue()
            }

            if (showSuggestions) {
                Spacer(modifier = Modifier.height(8.dp))
            }

            WordList( wordlist = wordlist) { newWordlist -> wordlist = newWordlist }

            Spacer(modifier = Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(
                    onClick = { wordlist = emptyArray() },
                    enabled = wordlist.isNotEmpty()
                ) {
                    Text("Reset")
                    Icon(
                        Icons.Default.RestartAlt,
                        contentDescription = "Reset",
                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
                Button(
                    onClick = { process(wordlist, bip39Dictionary) },
                    enabled = Bip39.validate(wordlist, bip39Dictionary)
                ) {
                    Text("Import")
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowRightAlt,
                        contentDescription = "Import",
                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text("Word count: ${wordlist.size}")

            if (informationMessage.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))

                Text(informationMessage,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth().
                        align(Alignment.CenterHorizontally))
            }
        }
    }
}

private fun filterSuggestions(
    suggestions: Array<String>,
    value: String,
    wordlist: Array<String>
) = if (value.trim().isEmpty()) {
    suggestions
} else {
    suggestions
        .filter {
            !wordlist.contains(it) && it.startsWith(value.trim(), ignoreCase = true)
        }
        .toTypedArray()
}

private fun createEmptyValue(): TextFieldValue
= TextFieldValue(
    text = "",
    selection = TextRange(0)
)

private fun updateWordlist(wordlist: Array<String>, value: String )
= if (!wordlist.contains(value.trim())) {
    wordlist.plus(arrayOf(value.trim()))
} else {
    wordlist
}

fun process(wordlist: Array<String>, dictionary: Array<String>) {
    val bip39 = Bip39(wordlist, dictionary)
    Memory.bip39 = Bip39Data(bip39)
}

@LightAndDarkModesPreview
@LightAndDarkDynamicColorsPreview
@Composable
fun PreviewMnemonicInputScreen() {
    ApplicationTheme {
        MnemonicInputScreen()
    }
}
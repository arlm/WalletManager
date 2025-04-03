@file:Suppress("unused")

package br.com.alexandremarcondes.walletmanager.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Locale

val seed = Color(0xFF00629D)
val purple_200 = Color(0xFFBB86FC)
val purple_500 = Color(0xFF6200EE)
val purple_700 = Color(0xFF3700B3)
val teal_200 = Color(0xFF03DAC5)
val teal_700 = Color(0xFF018786)
val black = Color(0xFF000000)
val white = Color(0xFFFFFFFF)
val yellow = Color(0xFFFFFF00)
val blue = Color(0xFF0000FF)
val green = Color(0xFF00FF00)
val red = Color(0xFFFF0000)
val pink = Color(0xFFFF00FF)
val cyan = Color(0xFF00FFFF)
val light_yellow = Color(0xFFFFFF7F)
val light_blue = Color(0xFF007FFF)
val light_green = Color(0xFF00FF7F)
val purple = Color(0xFF7F7FFF)
val teal = Color(0xFF007F7F)
val gray = Color(0xFF7F7F7F)
val orange = Color(0xFFFF7F00)
val icon_background = Color(0xFF2196F3)

@Preview(widthDp = 700)
@Composable
fun BaseColorsPreview(
) {
    Column {
        ColorRowPreview(
            "seed",
            primary = seed,
        )
    }
}

@Composable
fun ColorRowPreview(
    colorName: String,
    colorSuffix: String? = null,
    primary: Color? = null,
    onPrimary: Color? = null,
    primaryContainer: Color? = null,
    onPrimaryContainer: Color? = null
) {
    val capitalizedColorName = colorName.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(
            Locale.getDefault()
        ) else it.toString()
    }

    if (primary != null && onPrimary == null) {
        ColorPreview(colorName, primary, primary.invert())
    } else {
        Row {
            if (primary != null && onPrimary != null) {
                ColorPreview(colorName, primary, onPrimary)
                ColorPreview("on$capitalizedColorName", onPrimary, primary)
            }

            if (primaryContainer != null && onPrimaryContainer != null) {
                ColorPreview("${colorName}${colorSuffix}", primaryContainer, onPrimaryContainer)
                ColorPreview(
                    "on${capitalizedColorName}${colorSuffix}", onPrimaryContainer,
                    primaryContainer
                )
            }
        }
    }
}

fun Color.invert(): Color {
    return Color(1 - this.red, 1 - this.green, 1 - this.blue)
}

@Composable
fun ColorPreview(
    name: String,
    color: Color,
    onColor: Color
) {
    Box(
        modifier = Modifier
            .width(175.dp)
            .height(75.dp)
            .padding(4.dp)
            .border(
                border = BorderStroke(1.dp, onColor),
                shape = smallRoundShape.full
            )
            .clip(smallRoundShape.full)
            .background(color)
    ) {
        BasicText(
            text = name,
            modifier = Modifier.padding(8.dp, 4.dp),
            style = bodySmall.plus(TextStyle(color = onColor))
        )
    }
}
@file:Suppress("unused", "SpellCheckingInspection")

package br.com.alexandremarcondes.walletmanager.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.EmojiSupportMatch
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val defaultTextStyle = TextStyle.Default.copy(
    platformStyle = PlatformTextStyle(
        emojiSupportMatch = EmojiSupportMatch.Default
    )
)
val defaultFontFamily: FontFamily = FontFamily.Default

val headlineLarge = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 32.sp,
    lineHeight = 40.sp,
    letterSpacing = 0.0.sp
)

val headlineMedium = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 28.sp,
    lineHeight = 36.sp,
    letterSpacing = 0.0.sp
)

val headlineSmall = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    lineHeight = 32.sp,
    letterSpacing = 0.0.sp
)

val titleLarge = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 22.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.0.sp
)

val titleMedium = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.2.sp
)

val titleSmall = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.1.sp
)

val bodyLarge = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)

val bodyMedium = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.2.sp
)

val bodySmall = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.4.sp
)

val labelLarge = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.1.sp
)

val labelMedium = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
)

val labelSmall = defaultTextStyle.copy(
    fontWeight = FontWeight.SemiBold,
    fontSize = 11.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
)

val displayLarge = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 64.sp,
    lineHeight = 57.sp,
    letterSpacing = (-0.2).sp
)

val displayMedium = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 45.sp,
    lineHeight = 52.sp,
    letterSpacing = 0.0.sp
)

val displaySmall = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 36.sp,
    lineHeight = 44.sp,
    letterSpacing = 0.0.sp
)

@Preview(widthDp = 520, name = "Android Phone")
@Composable
fun AndroidTypesetPreview() {
    Column {
        Row {

            Column {
                TextPreview("title Large", titleLarge)
                TextPreview("title Medium", titleMedium)
                TextPreview("title Small", titleSmall)
            }
            Column {
                TextPreview("body Large", bodyLarge)
                TextPreview("body Medium", bodyMedium)
                TextPreview("body Small", bodySmall)
            }
            Column {
                TextPreview("label Large", labelLarge)
                TextPreview("label Medium", labelMedium)
                TextPreview("label Small", labelSmall)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Column {
                TextPreview("headline Large", headlineLarge)
                TextPreview("headline Medium", headlineMedium)
                TextPreview("headline Small", headlineSmall)
            }
            Column {
                TextPreview("display Large", displayLarge, width = 350.dp)
                TextPreview("display Medium", displayMedium, width = 350.dp)
                TextPreview("display Small", displaySmall, width = 350.dp)
            }
        }
    }
}

val display1: TextStyle = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 40.sp,
    lineHeight = 46.sp,
    letterSpacing = 0.5.sp
)

val display2: TextStyle = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 34.sp,
    lineHeight = 40.sp,
    letterSpacing = 1.sp
)

val display3: TextStyle = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 30.sp,
    lineHeight = 36.sp,
    letterSpacing = 0.8.sp,
)

val title1: TextStyle = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 24.sp,
    lineHeight = 28.sp,
    letterSpacing = 0.2.sp
)

val title2: TextStyle = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.2.sp
)

val title3: TextStyle = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.2.sp
)

val body1: TextStyle = defaultTextStyle.copy(
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 20.sp,
    letterSpacing = 0.18.sp
)

val body2: TextStyle = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 18.sp,
    letterSpacing = 0.2.sp
)

val button: TextStyle = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 15.sp,
    lineHeight = 19.sp,
    letterSpacing = 0.38.sp
)

val caption1: TextStyle = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 18.sp,
    letterSpacing = 0.1.sp
)

val caption2: TextStyle = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.1.sp
)

val caption3: TextStyle = defaultTextStyle.copy(
    fontFamily = defaultFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 10.sp,
    lineHeight = 14.sp,
    letterSpacing = 0.1.sp
)

val typography = Typography(
    headlineLarge = headlineLarge,
    headlineMedium = headlineMedium,
    headlineSmall = headlineSmall,

    titleLarge = titleLarge,
    titleMedium = titleMedium,
    titleSmall = titleSmall,

    bodyLarge = bodyLarge,
    bodyMedium = bodyMedium,
    bodySmall = bodySmall,

    labelLarge = labelLarge,
    labelMedium = labelMedium,
    labelSmall = labelSmall,

    displayLarge = displayLarge,
    displayMedium = displayMedium,
    displaySmall = displaySmall
)

@PreviewFontScales
@Composable
fun TypographyPreview() {
    ApplicationTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                        .semantics { selected = true }
                )
                {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = "Frank",
                            style = MaterialTheme.typography.headlineLarge
                        )

                        Text(
                            text = "20 mins ago",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.labelMedium
                        )

                        Text(
                            text = "E-Mail subject",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
                        )

                        Text(
                            text = "Vestibulum id ligula porta felis euismod semper. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Maecenas sed diam eget risus varius blandit sit amet non magna. Donec ullamcorper nulla non metus auctor fringilla. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                                    "\n" +
                                    "Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Maecenas faucibus mollis interdum. Vestibulum id ligula porta felis euismod semper. Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Aenean lacinia bibendum nulla sed consectetur. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer posuere erat a ante venenatis dapibus posuere velit aliquet.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TextPreview(
    name: String,
    style: TextStyle,
    width: Dp = 175.dp
) {
    BasicText(
        text = name,
        modifier = Modifier
            .width(width)
            .padding(8.dp, 4.dp)
            .background(md_theme_light_background),
        style = style.merge(TextStyle(color = md_theme_light_primary)),
        overflow = TextOverflow.Ellipsis
    )
}
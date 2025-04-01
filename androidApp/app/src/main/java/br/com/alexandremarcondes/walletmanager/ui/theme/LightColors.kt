package br.com.alexandremarcondes.walletmanager.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF00629E)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFCFE5FF)
val md_theme_light_onPrimaryContainer = Color(0xFF001D34)
val md_theme_light_secondary = Color(0xFF526070)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFD5E4F7)
val md_theme_light_onSecondaryContainer = Color(0xFF0E1D2A)
val md_theme_light_tertiary = Color(0xFF4459A9)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFDDE1FF)
val md_theme_light_onTertiaryContainer = Color(0xFF001453)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFCFCFF)
val md_theme_light_onBackground = Color(0xFF1A1C1E)
val md_theme_light_surface = Color(0xFFFCFCFF)
val md_theme_light_onSurface = Color(0xFF1A1C1E)
val md_theme_light_surfaceVariant = Color(0xFFDEE3EB)
val md_theme_light_onSurfaceVariant = Color(0xFF42474E)
val md_theme_light_outline = Color(0xFF72777F)
val md_theme_light_inverseOnSurface = Color(0xFFF1F0F4)
val md_theme_light_inverseSurface = Color(0xFF2F3033)
val md_theme_light_inversePrimary = Color(0xFF99CBFF)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF00629E)
val md_theme_light_outlineVariant = Color(0xFFC2C7CF)
val md_theme_light_scrim = Color(0xFF000000)

val lightColors = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim
)

@LightModeTabletPreview
@Composable
fun LightColorThemePreview() {
    ThemePreview()
}

@Composable
internal fun ThemePreview() {
    ApplicationTheme {
        Column {
            ColorRowPreview(
                "primary",
                "Container",
                MaterialTheme.colorScheme.primary,
                MaterialTheme.colorScheme.onPrimary,
                MaterialTheme.colorScheme.primaryContainer,
                MaterialTheme.colorScheme.onPrimaryContainer
            )

            ColorRowPreview(
                "secondary",
                "Container",
                MaterialTheme.colorScheme.secondary,
                MaterialTheme.colorScheme.onSecondary,
                MaterialTheme.colorScheme.secondaryContainer,
                MaterialTheme.colorScheme.onSecondaryContainer
            )

            ColorRowPreview(
                "tertiary",
                "Container",
                MaterialTheme.colorScheme.tertiary,
                MaterialTheme.colorScheme.onTertiary,
                MaterialTheme.colorScheme.tertiaryContainer,
                MaterialTheme.colorScheme.onTertiaryContainer
            )

            ColorRowPreview(
                "error",
                "Container",
                MaterialTheme.colorScheme.error,
                MaterialTheme.colorScheme.onError,
                MaterialTheme.colorScheme.errorContainer,
                MaterialTheme.colorScheme.onErrorContainer
            )

            ColorRowPreview(
                "surface",
                "Variant",
                MaterialTheme.colorScheme.surface,
                MaterialTheme.colorScheme.onSurface,
                MaterialTheme.colorScheme.surfaceVariant,
                MaterialTheme.colorScheme.onSurfaceVariant
            )

            ColorRowPreview(
                "inverse",
                "Surface",
                primaryContainer = MaterialTheme.colorScheme.inverseSurface,
                onPrimaryContainer = MaterialTheme.colorScheme.inverseOnSurface
            )

            ColorRowPreview(
                "outline",
                "Variant",
                primaryContainer = MaterialTheme.colorScheme.outline,
                onPrimaryContainer = MaterialTheme.colorScheme.outlineVariant
            )

            Row {
                ColorRowPreview(
                    "inversePrimary",
                    primary = MaterialTheme.colorScheme.inversePrimary,
                )

                ColorRowPreview(
                    "surfaceTint",
                    primary = MaterialTheme.colorScheme.surfaceTint,
                )

                ColorRowPreview(
                    "scrim",
                    primary = MaterialTheme.colorScheme.scrim,
                )
            }
        }
    }
}

@DarkModeTabletPreview
@Composable
fun LightColorsPreview(
) {
    Column {
        ColorRowPreview(
            "primary",
            "Container",
            md_theme_light_primary,
            md_theme_light_onPrimary,
            md_theme_light_primaryContainer,
            md_theme_light_onPrimaryContainer
        )

        ColorRowPreview(
            "secondary",
            "Container",
            md_theme_light_secondary,
            md_theme_light_onSecondary,
            md_theme_light_secondaryContainer,
            md_theme_light_onSecondaryContainer
        )

        ColorRowPreview(
            "tertiary",
            "Container",
            md_theme_light_tertiary,
            md_theme_light_onTertiary,
            md_theme_light_tertiaryContainer,
            md_theme_light_onTertiaryContainer
        )

        ColorRowPreview(
            "error",
            "Container",
            md_theme_light_error,
            md_theme_light_onError,
            md_theme_light_errorContainer,
            md_theme_light_onErrorContainer
        )

        ColorRowPreview(
            "surface",
            "Variant",
            md_theme_light_surface,
            md_theme_light_onSurface,
            md_theme_light_surfaceVariant,
            md_theme_light_onSurfaceVariant
        )

        ColorRowPreview(
            "inverse",
            "Surface",
            primaryContainer = md_theme_light_inverseSurface,
            onPrimaryContainer = md_theme_light_inverseOnSurface
        )

        ColorRowPreview(
            "outline",
            "Variant",
            primaryContainer = md_theme_light_outline,
            onPrimaryContainer = md_theme_light_outlineVariant
        )

        Row {
            ColorRowPreview(
                "inversePrimary",
                primary = md_theme_light_inversePrimary,
            )

            ColorRowPreview(
                "shadow",
                primary = md_theme_light_shadow,
            )

            ColorRowPreview(
                "surfaceTint",
                primary = md_theme_light_surfaceTint,
            )

            ColorRowPreview(
                "scrim",
                primary = md_theme_light_scrim,
            )
        }

        ColorRowPreview(
            "seed",
            primary = seed,
        )
    }
}
package br.com.alexandremarcondes.walletmanager.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val md_theme_dark_primary = Color(0xFF99CBFF)
val md_theme_dark_onPrimary = Color(0xFF003355)
val md_theme_dark_primaryContainer = Color(0xFF004A78)
val md_theme_dark_onPrimaryContainer = Color(0xFFCFE5FF)
val md_theme_dark_secondary = Color(0xFFB9C8DA)
val md_theme_dark_onSecondary = Color(0xFF243240)
val md_theme_dark_secondaryContainer = Color(0xFF3A4857)
val md_theme_dark_onSecondaryContainer = Color(0xFFD5E4F7)
val md_theme_dark_tertiary = Color(0xFFB7C4FF)
val md_theme_dark_onTertiary = Color(0xFF0E2878)
val md_theme_dark_tertiaryContainer = Color(0xFF2B4090)
val md_theme_dark_onTertiaryContainer = Color(0xFFDDE1FF)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF1A1C1E)
val md_theme_dark_onBackground = Color(0xFFE2E2E5)
val md_theme_dark_surface = Color(0xFF1A1C1E)
val md_theme_dark_onSurface = Color(0xFFE2E2E5)
val md_theme_dark_surfaceVariant = Color(0xFF42474E)
val md_theme_dark_onSurfaceVariant = Color(0xFFC2C7CF)
val md_theme_dark_outline = Color(0xFF8C9199)
val md_theme_dark_inverseOnSurface = Color(0xFF1A1C1E)
val md_theme_dark_inverseSurface = Color(0xFFE2E2E5)
val md_theme_dark_inversePrimary = Color(0xFF00629E)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFF99CBFF)
val md_theme_dark_outlineVariant = Color(0xFF42474E)
val md_theme_dark_scrim = Color(0xFF000000)

val darkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim
)

@DarkModeTabletPreview
@Composable
fun DarkColorThemePreview() {
    ThemePreview()
}

@LightModeTabletPreview
@Composable
fun DarkColorsPreview(
) {
    Column {
        ColorRowPreview(
            "primary",
            "Container",
            md_theme_dark_primary,
            md_theme_dark_onPrimary,
            md_theme_dark_primaryContainer,
            md_theme_dark_onPrimaryContainer
        )

        ColorRowPreview(
            "secondary",
            "Container",
            md_theme_dark_secondary,
            md_theme_dark_onSecondary,
            md_theme_dark_secondaryContainer,
            md_theme_dark_onSecondaryContainer
        )

        ColorRowPreview(
            "tertiary",
            "Container",
            md_theme_dark_tertiary,
            md_theme_dark_onTertiary,
            md_theme_dark_tertiaryContainer,
            md_theme_dark_onTertiaryContainer
        )

        ColorRowPreview(
            "error",
            "Container",
            md_theme_dark_error,
            md_theme_dark_onError,
            md_theme_dark_errorContainer,
            md_theme_dark_onErrorContainer
        )

        ColorRowPreview(
            "surface",
            "Variant",
            md_theme_dark_surface,
            md_theme_dark_onSurface,
            md_theme_dark_surfaceVariant,
            md_theme_dark_onSurfaceVariant
        )

        ColorRowPreview(
            "inverse",
            "Surface",
            primaryContainer = md_theme_dark_inverseSurface,
            onPrimaryContainer = md_theme_dark_inverseOnSurface
        )

        ColorRowPreview(
            "outline",
            "Variant",
            primaryContainer = md_theme_dark_outline,
            onPrimaryContainer = md_theme_dark_outlineVariant
        )

        Row {
            ColorRowPreview(
                "inversePrimary",
                primary = md_theme_dark_inversePrimary,
            )

            ColorRowPreview(
                "shadow",
                primary = md_theme_dark_shadow,
            )

            ColorRowPreview(
                "surfaceTint",
                primary = md_theme_dark_surfaceTint,
            )

            ColorRowPreview(
                "scrim",
                primary = md_theme_dark_scrim,
            )
        }

        ColorRowPreview(
            "seed",
            primary = seed,
        )
    }
}
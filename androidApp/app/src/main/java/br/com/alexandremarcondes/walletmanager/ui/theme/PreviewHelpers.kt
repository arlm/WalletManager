@file:Suppress("unused")

package br.com.alexandremarcondes.walletmanager.ui.theme

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers

private const val defaultApiLevel = 34
private const val oldApiLevel = 30

private const val phoneDevice = Devices.PIXEL_7
private const val tabletDevice = Devices.PIXEL_C

/**
 * MultiPreview annotation that represents various phone presentation types like dark and light modes,
 * and all dynamic color variations.
 * Add this annotation to a composable to render various phone variations.
 */
@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Phone Light",
    showSystemUi = true,
    device = phoneDevice,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.NONE,
    backgroundColor = 0xFFFFFF,
    showBackground = true,
    group = "light",
    apiLevel = oldApiLevel
)
@Preview(
    name = "Phone Dark",
    showSystemUi = true,
    device = phoneDevice,
    wallpaper = Wallpapers.NONE,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    backgroundColor = 0x000000,
    showBackground = true, group = "dark",
    apiLevel = oldApiLevel
)
@Preview(
    name = "Phone Yellow Light",
    showSystemUi = true,
    device = phoneDevice,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    backgroundColor = 0xebc934,
    showBackground = true,
    group = "light",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Phone Yellow Dark",
    showSystemUi = true,
    device = phoneDevice,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    backgroundColor = 0xebc934,
    showBackground = true,
    group = "dark",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Phone Blue Light",
    showSystemUi = true,
    device = phoneDevice,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    backgroundColor = 0x349beb,
    showBackground = true,
    group = "light",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Phone Blue Dark",
    showSystemUi = true,
    device = phoneDevice,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    backgroundColor = 0x349beb,
    showBackground = true,
    group = "dark",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Phone Green Light",
    showSystemUi = true,
    device = phoneDevice,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    backgroundColor = 0x34eb83,
    showBackground = true,
    group = "light",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Phone Green Dark",
    showSystemUi = true,
    device = phoneDevice,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    backgroundColor = 0x34eb83,
    showBackground = true,
    group = "dark",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Phone Red Light",
    showSystemUi = true,
    device = phoneDevice,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    backgroundColor = 0xf07ab3,
    showBackground = true,
    group = "light",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Phone Red Dark",
    showSystemUi = true,
    device = phoneDevice,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    backgroundColor = 0xf07ab3,
    showBackground = true,
    group = "dark",
    apiLevel = defaultApiLevel
)
annotation class AndroidPhonePreviews

/**
 * MultiPreview annotation that represents various API Level 30 tablet presentation types
 * like dark and light modes.
 * Add this annotation to a composable to render various tablet variations.
 */
@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Tablet Light",
    showSystemUi = true,
    device = tabletDevice,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.NONE,
    backgroundColor = 0xFFFFFF,
    showBackground = true,
    group = "light",
    apiLevel = oldApiLevel
)
@Preview(
    name = "Tablet Dark",
    showSystemUi = true,
    device = tabletDevice,
    wallpaper = Wallpapers.NONE,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    backgroundColor = 0x000000,
    showBackground = true,
    group = "dark",
    apiLevel = oldApiLevel
)
annotation class AndroidTabletApi30Previews

/**
 * MultiPreview annotation that represents various API Level 31 tablet presentation types
 * like dark and light modes, and all dynamic color variations.
 * Add this annotation to a composable to render various phone variations.
 */
@Preview(
    name = "Tablet Yellow Light",
    showSystemUi = true,
    device = tabletDevice,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    backgroundColor = 0xebc934,
    showBackground = true,
    group = "light",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Tablet Yellow Dark",
    showSystemUi = true,
    device = tabletDevice,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    backgroundColor = 0xebc934,
    showBackground = true,
    group = "dark",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Tablet Blue Light",
    showSystemUi = true,
    device = tabletDevice,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    backgroundColor = 0x349beb,
    showBackground = true,
    group = "light",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Tablet Blue Dark",
    showSystemUi = true,
    device = tabletDevice,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    backgroundColor = 0x349beb,
    showBackground = true,
    group = "dark",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Tablet Green Light",
    showSystemUi = true,
    device = tabletDevice,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    backgroundColor = 0x34eb83,
    showBackground = true,
    group = "light",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Tablet Green Dark",
    showSystemUi = true,
    device = tabletDevice,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    backgroundColor = 0x34eb83,
    showBackground = true,
    group = "dark",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Tablet Red Light",
    showSystemUi = true,
    device = tabletDevice,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    backgroundColor = 0xf07ab3,
    showBackground = true,
    group = "light",
    apiLevel = defaultApiLevel
)
@Preview(
    name = "Tablet Red Dark",
    showSystemUi = true,
    device = tabletDevice,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    backgroundColor = 0xf07ab3,
    showBackground = true,
    group = "dark",
    apiLevel = defaultApiLevel
)
annotation class AndroidTabletApi31Previews

/**
 * MultiPreview annotation that represents various API Levels 30 and 31 tablet presentation types
 * like dark and light modes, and all dynamic color variations.
 * Add this annotation to a composable to render various phone variations.
 */
@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@AndroidTabletApi30Previews
@AndroidTabletApi31Previews
annotation class AndroidTabletPreviews


@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Blue Light",
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    apiLevel = defaultApiLevel,
    device = phoneDevice,
    backgroundColor = 0xebc934,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class LightDynamicBluePreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Yellow Light",
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    apiLevel = defaultApiLevel,
    device = phoneDevice,
    backgroundColor = 0x349beb,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class LightDynamicYellowPreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Green Light",
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    apiLevel = defaultApiLevel,
    device = phoneDevice,
    backgroundColor = 0x34eb83,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class LightDynamicGreenPreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Red Light",
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    apiLevel = defaultApiLevel,
    device = phoneDevice,
    backgroundColor = 0xf07ab3,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class LightDynamicRedPreview

/**
 * MultiPreview annotation that represents all light API Levels 31 dynamic color variations.
 */
@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@LightDynamicBluePreview
@LightDynamicYellowPreview
@LightDynamicGreenPreview
@LightDynamicRedPreview
annotation class LightDynamicColorsPreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Blue Dark",
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    apiLevel = defaultApiLevel,
    device = phoneDevice,
    backgroundColor = 0xebc934,
    showBackground = true,
    group = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class DarkDynamicBluePreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Yellow Dark",
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    apiLevel = defaultApiLevel,
    device = phoneDevice,
    backgroundColor = 0x349beb,
    showBackground = true,
    group = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class DarkDynamicYellowPreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Green Dark",
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    apiLevel = defaultApiLevel,
    device = phoneDevice,
    backgroundColor = 0x34eb83,
    showBackground = true,
    group = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class DarkDynamicGreenPreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Red Dark",
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    apiLevel = defaultApiLevel,
    device = phoneDevice,
    backgroundColor = 0xf07ab3,
    showBackground = true,
    group = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class DarkDynamicRedPreview

/**
 * MultiPreview annotation that represents all dark API Levels 31 dynamic color variations.
 */
@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@DarkDynamicBluePreview
@DarkDynamicYellowPreview
@DarkDynamicGreenPreview
@DarkDynamicRedPreview
annotation class DarkDynamicColorsPreview

/**
 * MultiPreview annotation that represents all light and dark API Levels 31 dynamic color variations.
 */
@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@LightDynamicColorsPreview
@DarkDynamicColorsPreview
annotation class LightAndDarkDynamicColorsPreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Light Mode",
    apiLevel = oldApiLevel,
    showSystemUi = true,
    device = phoneDevice,
    backgroundColor = 0xFFFFFF,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class LightPhonePreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Light Mode",
    apiLevel = oldApiLevel,
    backgroundColor = 0xFFFFFF,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class LightModePreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Light Mode",
    apiLevel = oldApiLevel,
    device = tabletDevice,
    showSystemUi = true,
    backgroundColor = 0xFFFFFF,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class LightModeTabletPreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Light Mode",
    apiLevel = oldApiLevel,
    device = phoneDevice,
    showSystemUi = true,
    backgroundColor = 0xFFFFFF,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class LightModePhonePreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Dark Mode",
    apiLevel = oldApiLevel,
    device = phoneDevice,
    showSystemUi = true,
    backgroundColor = 0x000000,
    showBackground = true,
    group = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class DarkPhonePreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Dark Mode",
    apiLevel = oldApiLevel,
    backgroundColor = 0x000000,
    showBackground = true,
    group = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class DarkModePreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Dark Mode",
    apiLevel = oldApiLevel,
    device = tabletDevice,
    backgroundColor = 0x000000,
    showBackground = true,
    showSystemUi = true,
    group = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class DarkModeTabletPreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Dark Mode",
    apiLevel = oldApiLevel,
    device = phoneDevice,
    backgroundColor = 0x000000,
    showBackground = true,
    showSystemUi = true,
    group = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class DarkModePhonePreview

/**
 * MultiPreview annotation that represents API Levels 30 dark and light modes.
 */
@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@LightPhonePreview
@DarkPhonePreview
annotation class LightAndDarkPhonePreview

/**
 * MultiPreview annotation that represents API Levels 30 dark and light modes.
 */
@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@LightModePreview
@DarkModePreview
annotation class LightAndDarkModesPreview

/**
 * A MultiPreview annotation for displaying a @Composable method using the screen sizes of five different reference devices.
 */
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION
)
@Preview(name = "Phone", device = "spec:width=411dp,height=891dp", apiLevel = defaultApiLevel)
@Preview(
    name = "Phone - Landscape",
    device = "spec:width=411dp,height=891dp,orientation=landscape,dpi=420",
    apiLevel = defaultApiLevel
)
@Preview(name = "Unfolded Foldable", device = "spec:width=673dp,height=841dp", apiLevel = defaultApiLevel)
@Preview(name = "Tablet", device = "spec:width=1280dp,height=800dp,dpi=240", apiLevel = defaultApiLevel)
@Preview(name = "Desktop", device = "spec:width=1920dp,height=1080dp,dpi=160", apiLevel = defaultApiLevel)
@Preview(name = "TV 1080p", device = Devices.TV_1080p, apiLevel = defaultApiLevel)
@Preview(name = "TV 720p", device = Devices.TV_720p, apiLevel = defaultApiLevel)
annotation class PreviewScreenSizes

/**
 * A MultiPreview annotation for displaying a @Composable method using seven standard font sizes.
 */
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION
)
@Preview(name = "50%", fontScale = 0.5f, apiLevel = defaultApiLevel)
@Preview(name = "85%", fontScale = 0.75f, apiLevel = defaultApiLevel)
@Preview(name = "85%", fontScale = 0.85f, apiLevel = defaultApiLevel)
@Preview(name = "100%", fontScale = 1.0f, apiLevel = defaultApiLevel)
@Preview(name = "115%", fontScale = 1.15f, apiLevel = defaultApiLevel)
@Preview(name = "125%", fontScale = 1.25f, apiLevel = defaultApiLevel)
@Preview(name = "130%", fontScale = 1.3f, apiLevel = defaultApiLevel)
@Preview(name = "150%", fontScale = 1.5f, apiLevel = defaultApiLevel)
@Preview(name = "175%", fontScale = 1.75f, apiLevel = defaultApiLevel)
@Preview(name = "180%", fontScale = 1.8f, apiLevel = defaultApiLevel)
@Preview(name = "200%", fontScale = 2f, apiLevel = defaultApiLevel)
annotation class PreviewFontScales

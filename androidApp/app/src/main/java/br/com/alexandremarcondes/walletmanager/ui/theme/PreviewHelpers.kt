package br.com.alexandremarcondes.walletmanager.ui.theme

import android.content.res.Configuration
import android.os.Build
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers

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
    device = Devices.NEXUS_6,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.NONE,
    backgroundColor = 0xFFFFFF,
    showBackground = true,
    group = "light",
    apiLevel = 30
)
@Preview(
    name = "Phone Dark",
    showSystemUi = true,
    device = Devices.NEXUS_6,
    wallpaper = Wallpapers.NONE,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    backgroundColor = 0x000000,
    showBackground = true, group = "dark",
    apiLevel = 30
)
@Preview(
    name = "Phone Yellow Light",
    showSystemUi = true,
    device = Devices.NEXUS_6,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    backgroundColor = 0xebc934,
    showBackground = true,
    group = "light",
    apiLevel = 31
)
@Preview(
    name = "Phone Yellow Dark",
    showSystemUi = true,
    device = Devices.NEXUS_6,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    backgroundColor = 0xebc934,
    showBackground = true,
    group = "dark",
    apiLevel = 31
)
@Preview(
    name = "Phone Blue Light",
    showSystemUi = true,
    device = Devices.NEXUS_6,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    backgroundColor = 0x349beb,
    showBackground = true,
    group = "light",
    apiLevel = 31
)
@Preview(
    name = "Phone Blue Dark",
    showSystemUi = true,
    device = Devices.NEXUS_6,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    backgroundColor = 0x349beb,
    showBackground = true,
    group = "dark",
    apiLevel = 31
)
@Preview(
    name = "Phone Green Light",
    showSystemUi = true,
    device = Devices.NEXUS_6,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    backgroundColor = 0x34eb83,
    showBackground = true,
    group = "light",
    apiLevel = 31
)
@Preview(
    name = "Phone Green Dark",
    showSystemUi = true,
    device = Devices.NEXUS_6,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    backgroundColor = 0x34eb83,
    showBackground = true,
    group = "dark",
    apiLevel = 31
)
@Preview(
    name = "Phone Red Light",
    showSystemUi = true,
    device = Devices.NEXUS_6,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    backgroundColor = 0xf07ab3,
    showBackground = true,
    group = "light",
    apiLevel = 31
)
@Preview(
    name = "Phone Red Dark",
    showSystemUi = true,
    device = Devices.NEXUS_6,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    backgroundColor = 0xf07ab3,
    showBackground = true,
    group = "dark",
    apiLevel = 31
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
    device = Devices.PIXEL_C,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.NONE,
    backgroundColor = 0xFFFFFF,
    showBackground = true,
    group = "light",
    apiLevel = 30
)
@Preview(
    name = "Tablet Dark",
    showSystemUi = true,
    device = Devices.PIXEL_C,
    wallpaper = Wallpapers.NONE,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    backgroundColor = 0x000000,
    showBackground = true,
    group = "dark",
    apiLevel = 30
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
    device = Devices.PIXEL_C,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    backgroundColor = 0xebc934,
    showBackground = true,
    group = "light",
    apiLevel = 31
)
@Preview(
    name = "Tablet Yellow Dark",
    showSystemUi = true,
    device = Devices.PIXEL_C,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    backgroundColor = 0xebc934,
    showBackground = true,
    group = "dark",
    apiLevel = 31
)
@Preview(
    name = "Tablet Blue Light",
    showSystemUi = true,
    device = Devices.PIXEL_C,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    backgroundColor = 0x349beb,
    showBackground = true,
    group = "light",
    apiLevel = 31
)
@Preview(
    name = "Tablet Blue Dark",
    showSystemUi = true,
    device = Devices.PIXEL_C,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE,
    backgroundColor = 0x349beb,
    showBackground = true,
    group = "dark",
    apiLevel = 31
)
@Preview(
    name = "Tablet Green Light",
    showSystemUi = true,
    device = Devices.PIXEL_C,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    backgroundColor = 0x34eb83,
    showBackground = true,
    group = "light",
    apiLevel = 31
)
@Preview(
    name = "Tablet Green Dark",
    showSystemUi = true,
    device = Devices.PIXEL_C,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    backgroundColor = 0x34eb83,
    showBackground = true,
    group = "dark",
    apiLevel = 31
)
@Preview(
    name = "Tablet Red Light",
    showSystemUi = true,
    device = Devices.PIXEL_C,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    backgroundColor = 0xf07ab3,
    showBackground = true,
    group = "light",
    apiLevel = 31
)
@Preview(
    name = "Tablet Red Dark",
    showSystemUi = true,
    device = Devices.PIXEL_C,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    backgroundColor = 0xf07ab3,
    showBackground = true,
    group = "dark",
    apiLevel = 31
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
    apiLevel = Build.VERSION_CODES.S,
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
    apiLevel = Build.VERSION_CODES.S,
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
    apiLevel = Build.VERSION_CODES.S,
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
    apiLevel = Build.VERSION_CODES.S,
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
    apiLevel = Build.VERSION_CODES.S,
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
    apiLevel = Build.VERSION_CODES.S,
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
    apiLevel = Build.VERSION_CODES.S,
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
    apiLevel = Build.VERSION_CODES.S,
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
    apiLevel = Build.VERSION_CODES.R,
    backgroundColor = 0xFFFFFF,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
annotation class LightModePreview

@Retention(value = AnnotationRetention.BINARY)
@Target(allowedTargets = [AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION])
@Preview(
    name = "Light Mode",
    apiLevel = Build.VERSION_CODES.R,
    device = Devices.PIXEL_C,
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
    apiLevel = Build.VERSION_CODES.R,
    device = Devices.NEXUS_6,
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
    apiLevel = Build.VERSION_CODES.R,
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
    apiLevel = Build.VERSION_CODES.R,
    device = Devices.PIXEL_C,
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
    apiLevel = Build.VERSION_CODES.R,
    device = Devices.NEXUS_6,
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
@LightModePreview
@DarkModePreview
annotation class LightAndDarkModesPreview

/**
 * A MultiPreview annotation for displaying a @[Composable] method using the screen sizes of five different reference devices.
 */
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION
)
@Preview(name = "Phone", device = "spec:width=411dp,height=891dp")
@Preview(
    name = "Phone - Landscape",
    device = "spec:width=411dp,height=891dp,orientation=landscape,dpi=420"
)
@Preview(name = "Unfolded Foldable", device = "spec:width=673dp,height=841dp")
@Preview(name = "Tablet", device = "spec:width=1280dp,height=800dp,dpi=240")
@Preview(name = "Desktop", device = "spec:width=1920dp,height=1080dp,dpi=160")
@Preview(name = "TV 1080p", device = Devices.TV_1080p)
@Preview(name = "TV 720p", device = Devices.TV_720p)
annotation class PreviewScreenSizes

/**
 * A MultiPreview annotation for displaying a @[Composable] method using seven standard font sizes.
 */
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION
)
@Preview(name = "50%", fontScale = 0.5f)
@Preview(name = "85%", fontScale = 0.75f)
@Preview(name = "85%", fontScale = 0.85f)
@Preview(name = "100%", fontScale = 1.0f)
@Preview(name = "115%", fontScale = 1.15f)
@Preview(name = "125%", fontScale = 1.25f)
@Preview(name = "130%", fontScale = 1.3f)
@Preview(name = "150%", fontScale = 1.5f)
@Preview(name = "175%", fontScale = 1.75f)
@Preview(name = "180%", fontScale = 1.8f)
@Preview(name = "200%", fontScale = 2f)
annotation class PreviewFontScales
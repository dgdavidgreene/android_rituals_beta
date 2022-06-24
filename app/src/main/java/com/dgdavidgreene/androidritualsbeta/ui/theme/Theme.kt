package com.dgdavidgreene.androidritualsbeta.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
/*
<resources xmlns:tools="http://schemas.android.com/tools">
<!-- Base application theme. -->
<style name="Theme.SplashScreens" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
<!-- Primary brand color. -->
<item name="colorPrimary">@color/purple_500</item>
<item name="colorPrimaryVariant">@color/purple_700</item>
<item name="colorOnPrimary">@color/white</item>
<!-- Secondary brand color. -->
<item name="colorSecondary">@color/teal_200</item>
<item name="colorSecondaryVariant">@color/teal_700</item>
<item name="colorOnSecondary">@color/black</item>
<!-- Status bar color. -->
<item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
<!-- Customize your theme here. -->
</style>

<style name="Theme.App.Starting" parent="Theme.SplashScreen">
// Set the splash screen background, animated icon, and animation duration.
<item name="windowSplashScreenBackground">@color/purple_700</item>

// Use windowSplashScreenAnimatedIcon to add either a drawable or an
// animated drawable. One of these is required.
<item name="windowSplashScreenAnimatedIcon">@drawable/ic_splash</item>
<item name="windowSplashScreenAnimationDuration">500</item>  # Required for
# animated icons
<item name="android:windowSplashScreenIconBackgroundColor" tools:targetApi="31">@color/teal_700</item>
<item name="android:windowSplashScreenBrandingImage" tools:targetApi="31">@drawable/ic_branding</item>

// set the theme that will be used once the Splash screen is no longer visible.
<item name="postSplashScreenTheme">@style/Theme.SplashScreens</item>  # Required.
</style>
</resources>
*/
private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun AndroidRitualsBetaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
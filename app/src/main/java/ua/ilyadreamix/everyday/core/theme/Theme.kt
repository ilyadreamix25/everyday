package ua.ilyadreamix.everyday.core.theme

import android.app.Activity
import android.view.WindowManager
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.material.Surface
import androidx.core.view.WindowCompat

// Dark theme color scheme
val DarkColors = darkColors(
    primary = AppBlue,
    background = AppBlack
)

// Light theme color scheme
val LightColors = lightColors(
    primary = AppBlue,
    background = AppWhite
)

/**
 * Basic app theme.
 * Use with [Surface]
 *
 * @param darkTheme Use dark theme
 * @param transparentSystemBars Use transparent system bars
 * @param content Content to be themed
 * @author IlyaDreamix
 */
@Composable
fun EverydayTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    transparentSystemBars: Boolean = false,
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        val activity = (view.context as Activity)

        // Set system bars color
        activity.window.statusBarColor = when {
            darkTheme -> (if (!transparentSystemBars) AppBlack else AppTransparent).toArgb()
            else -> (if (!transparentSystemBars) AppWhite else AppTransparent).toArgb()
        }
        activity.window.navigationBarColor = when {
            darkTheme -> (if (!transparentSystemBars) AppBlack else AppTransparent).toArgb()
            else -> (if (!transparentSystemBars) AppWhite else AppTransparent).toArgb()
        }

        // Set system bars layout settings
        WindowCompat.setDecorFitsSystemWindows(activity.window, false)
        activity.window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        // Set system bars content color
        val insetsController = WindowCompat.getInsetsController(activity.window, view)
        insetsController.isAppearanceLightStatusBars = !darkTheme
        insetsController.isAppearanceLightNavigationBars = !darkTheme
    }

    // Set theme
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        content = content
    )
}

package ua.ilyadreamix.everyday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.compose.rememberNavController
import ua.ilyadreamix.everyday.auth.AuthScreen
import ua.ilyadreamix.everyday.core.theme.EverydayTheme
import ua.ilyadreamix.everyday.splash.SplashScreenUI
import ua.ilyadreamix.everyday.splash.navigation.SplashNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EverydayTheme {
                val navController = rememberNavController()
                SplashNavHost(navController)
            }
        }
    }
}

@Composable
@Preview
fun PreviewSplashScreen() {
    EverydayTheme(darkTheme = true) {
        SplashScreenUI()
    }
}

@Composable
@Preview
fun PreviewAuthScreen() {
    EverydayTheme(darkTheme = true) {
        AuthScreen()
    }
}

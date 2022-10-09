package ua.ilyadreamix.everyday.splash.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ua.ilyadreamix.everyday.auth.AuthScreen
import ua.ilyadreamix.everyday.splash.SplashScreen

@Composable
fun SplashNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SplashRoutes.SPLASH
    ) {
        composable(route = SplashRoutes.SPLASH) {
            SplashScreen(navController = navController)
        }
        composable(route = SplashRoutes.AUTH) {
            AuthScreen()
        }
    }
}
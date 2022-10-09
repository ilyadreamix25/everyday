package ua.ilyadreamix.everyday.splash

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import ua.ilyadreamix.everyday.core.components.Logo
import ua.ilyadreamix.everyday.data.utils.SessionStatuses
import ua.ilyadreamix.everyday.data.utils.SessionUtil
import ua.ilyadreamix.everyday.splash.navigation.SplashRoutes

@Composable
fun SplashScreenUI() {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        ConstraintLayout(Modifier.fillMaxSize()) {
            val mainContent = createRef()

            Logo(
                64.sp,
                Modifier
                    .padding(12.dp)
                    .constrainAs(mainContent) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    SplashScreenUI()

    val activity = LocalContext.current as ComponentActivity
    val sessionUtil = SessionUtil(activity)

    LaunchedEffect(Unit) {
        when (sessionUtil.getSessionStatus()) {
            SessionStatuses.SESSION_NULL ->
                navController.navigate(SplashRoutes.AUTH) {
                    popUpTo(0)
                }
            else ->
                navController.navigate(SplashRoutes.AUTH) {
                    popUpTo(0)
                }
        }
    }
}
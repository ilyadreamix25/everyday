package ua.ilyadreamix.everyday.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import ua.ilyadreamix.everyday.R
import ua.ilyadreamix.everyday.auth.signin.SignInUI
import ua.ilyadreamix.everyday.core.components.Logo
import ua.ilyadreamix.everyday.core.components.TextFieldSizedRoundedButton
import ua.ilyadreamix.everyday.core.theme.AppWhite

@Composable
fun AuthScreen() {
    Surface(color = MaterialTheme.colors.background) {
        ConstraintLayout(Modifier.fillMaxSize()) {
            val (centerColumn, bottomColumn) = createRefs()

            val isLoading = remember { mutableStateOf(false) }

            Column(
                Modifier.constrainAs(centerColumn) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
            ) {
                // Before OR column
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp)
                ) {
                    // Logo and text
                    Logo(64.sp, Modifier.padding(bottom = 10.dp))
                    Text(
                        text = stringResource(R.string.auth_text),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Sign in UI
                    SignInUI(isLoading = isLoading)
                }
            }

            Column(
                Modifier
                    .padding(top = 12.dp)
                    .constrainAs(bottomColumn) {
                        top.linkTo(centerColumn.bottom)
                    }
            ) {
                // OR separator
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    val orColor = MaterialTheme.colors.onBackground.copy(.25f)

                    Divider(
                        color = orColor,
                        modifier = Modifier.weight(.4f),
                        thickness = 1.dp
                    )
                    Text(
                        text = stringResource(R.string.auth_or).uppercase(),
                        color = orColor,
                        modifier = Modifier
                            .weight(.2f)
                            .padding(start = 6.dp, end = 6.dp),
                        textAlign = TextAlign.Center
                    )
                    Divider(
                        color = orColor,
                        modifier = Modifier.weight(.4f),
                        thickness = 1.dp
                    )
                }

                // After OR column
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Google sign in
                    TextFieldSizedRoundedButton(
                        text = stringResource(R.string.auth_continue_with_google),
                        enabled = isLoading,
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_google),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(32.dp)
                                    .padding(end = 4.dp),
                                tint = AppWhite
                            )
                        }
                    ) {
                        // Nothing
                    }

                    // Sign up redirect
                    TextButton(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.auth_dont_have_account),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}